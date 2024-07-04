package ru.clevertec.check;


import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.entity.Product;
import ru.clevertec.check.factory.FactoryGeneric;
import ru.clevertec.check.factory.FactoryService;
import ru.clevertec.check.service.DiscountCardService;
import ru.clevertec.check.service.ProductService;
import ru.clevertec.check.util.DiscountCardReaderCsv;
import ru.clevertec.check.util.ProductReaderCsv;

import java.util.HashMap;
import java.util.Map;

public class CheckRunner {
    static {
        ProductReaderCsv productReaderCsv = FactoryGeneric.getProductReaderCsv();
        String productsAddress = "src/main/resources/products.csv";
        productReaderCsv.loadProducts(productsAddress);
        ProductService productService = FactoryService.getProductService();



        DiscountCardReaderCsv discountCardReaderCsv = FactoryGeneric.getDiscountCardReaderCsv();
        String discountCardsAddress = "src/main/resources/discountCards.csv";
        discountCardReaderCsv.loadDiscountCards(discountCardsAddress);
        DiscountCardService discountCardService = FactoryService.getDiscountCardService();

    }
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java id-quantity discountCard=xxxx balanceDebitCard=xxxx");
            return;
        }

        ProductService productService = FactoryService.getProductService();
        DiscountCardService discountCardService = FactoryService.getDiscountCardService();

        // Parse arguments
        Long discountCardNumber = null;
        Double balanceDebitCard = null;
        Map<Long, Integer> productQuantities = new HashMap<>();

        for (String arg : args) {
            if (arg.startsWith("discountCard=")) {
                discountCardNumber = Long.parseLong(arg.split("=")[1]);
            } else if (arg.startsWith("balanceDebitCard=")) {
                balanceDebitCard = Double.parseDouble(arg.split("=")[1]);
            } else {
                String[] parts = arg.split("-");
                Long productId = Long.parseLong(parts[0]);
                Integer quantity = Integer.parseInt(parts[1]);
                productQuantities.put(productId, quantity);
            }
        }

        // Validate balance
        if (balanceDebitCard == null) {
            System.out.println("Error: balanceDebitCard parameter is required.");
            return;
        }

        // Calculate total cost and apply discounts
        double totalCost = 0.0;
        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Product product = productService.getProductById(entry.getKey()).orElseThrow();
            totalCost += product.getPrice() * entry.getValue();
        }

        // Apply discount if applicable
        if (discountCardNumber != null) {
            DiscountCard discountCard = discountCardService.getDiscountCard(discountCardNumber);
            if (discountCard != null) {
                double discount = totalCost * discountCard.getDiscountAmount() / 100.0;
                totalCost -= discount;
                System.out.println("Discount applied: " + discount);
            } else {
                System.out.println("Warning: Discount card not found.");
            }
        }

        // Check if balance is sufficient
        if (balanceDebitCard < totalCost) {
            System.out.println("Error: Insufficient balance on debit card.");
            return;
        }

        // Print receipt
        System.out.println("Receipt:");
        for (Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {
            Product product = productService.getProductById(entry.getKey()).orElseThrow();
            System.out.println(product.getDescription() + " x" + entry.getValue() + " = " + product.getPrice() * entry.getValue());
        }
        System.out.println("Total cost: " + totalCost);
    }
}

