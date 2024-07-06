package ru.clevertec.check.service;

import ru.clevertec.check.dto.ArgumentParserDto;
import ru.clevertec.check.entity.Check;
import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.entity.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CheckService {
    public final DiscountCardService discountCardService;
    public final ProductService productService;

    public CheckService(DiscountCardService discountCardService, ProductService productService) {
        this.discountCardService = discountCardService;
        this.productService = productService;
    }

    public Check getCheckFromCommandLine(ArgumentParserDto argumentParserDto) {

        Check checkAfterParseCommandLine = getCheckAfterParseCommandLine(argumentParserDto);
        return getCheck(checkAfterParseCommandLine);

    }


    public void printReceipt(Check check) {
        Map<Long, Integer> productQuantities = check.getProductQuantities();
        double totalCost = check.getTotalCost();
        System.out.println("Receipt:");
        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Product product = productService.getProductById(entry.getKey()).orElseThrow();
            System.out.println(product.getDescription() + " x" + entry.getValue() + " = " + product.getPrice() * entry.getValue());
        }
        System.out.println("Total cost: " + totalCost);
    }

    public void writeReceiptToCsv(Check check, String filePath) {
        Map<Long, Integer> productQuantities = check.getProductQuantities();
        double totalCost = check.getTotalCost();
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Product,Quantity,Price,Total\n");
            for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
                Product product = productService.getProductById(entry.getKey()).orElseThrow();
                double productTotal = product.getPrice() * entry.getValue();
                writer.append(product.getDescription())
                        .append(',')
                        .append(String.valueOf(entry.getValue()))
                        .append(',')
                        .append(String.valueOf(product.getPrice()))
                        .append(',')
                        .append(String.valueOf(productTotal))
                        .append('\n');
            }
            writer.append("Total Cost,,," + totalCost + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Check getCheckAfterParseCommandLine(ArgumentParserDto argumentParserDto) {
        Check check = Check.builder().build();

        Long discountCardNumber = argumentParserDto.getDiscountCardNumber();
        check.setDiscountCardNumber(discountCardNumber);

        Double balanceDebitCard = argumentParserDto.getBalanceDebitCard();
        check.setBalanceDebitCard(balanceDebitCard);

        Map<Long, Integer> productQuantities = argumentParserDto.getProductQuantities();
        check.setProductQuantities(productQuantities);


        return check;
    }


    public Check getCheck(Check check) {
        double totalCost = 0.0;
        Map<Long, Integer> productQuantities = check.getProductQuantities();
        Long discountCardNumber = check.getDiscountCardNumber();

        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Product product = productService.getProductById(entry.getKey()).orElseThrow();
            double itemCost = product.getPrice() * entry.getValue();

            if (product.isWholesale() && entry.getValue() > 5) {
                itemCost *= 0.90;
                System.out.println("Wholesale discount applied to product ID: " + product.getId());
            } else if (discountCardNumber != null) {
                DiscountCard discountCard = discountCardService.getDiscountCard(discountCardNumber);
                if (discountCard != null) {
                    double discount = itemCost * discountCard.getDiscountAmount() / 100.0;
                    itemCost -= discount;
                    System.out.println("Discount card applied: " + discount + " on product ID: " + product.getId());
                } else {
                    System.out.println("Warning: Discount card not found.");
                }
            }

            totalCost += itemCost;
            check.setTotalCost(totalCost);

        }
        return check;
    }


}
