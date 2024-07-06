package ru.clevertec.check.service;

import ru.clevertec.check.dto.ArgumentParserDto;
import ru.clevertec.check.entity.Check;
import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.entity.Product;

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
        return getSumTotalCost(checkAfterParseCommandLine);

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

    private Check getSumTotalCost(Check check) {
        Map<Long, Integer> productQuantities = check.getProductQuantities();
        double totalCost = 0.0;
        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Product product = productService.getProductById(entry.getKey()).orElseThrow();
            totalCost += product.getPrice() * entry.getValue();
        }
        check.setTotalCost(totalCost);
//        return totalCost;
        return getTotalCostAfterApplyDiscount(check);
    }


    private Check getTotalCostAfterApplyDiscount(Check check) {
        double totalCost = check.getTotalCost();
        Long discountCardNumber = check.getDiscountCardNumber();

        if (discountCardNumber != null) {
            DiscountCard discountCard = discountCardService.getDiscountCard(discountCardNumber);
            if (discountCard != null) {
                double discount = totalCost * discountCard.getDiscountAmount() / 100.0;
                System.out.println("Discount applied: " + discount);
                double v = totalCost - discount;
                check.setTotalCost(v);
                return check;

            } else {
                System.out.println("Warning: Discount card not found.");
            }
        }
//        return totalCost;
        return check;
    }



}
