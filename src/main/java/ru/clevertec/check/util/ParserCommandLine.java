package ru.clevertec.check.util;

import java.util.HashMap;
import java.util.Map;

public class ParserCommandLine {
    
    private static Map<Long, Integer> getProductQuantities(String[] args) {
        Map<Long, Integer> productQuantities = new HashMap<>();
        Long discountCardNumber = null;
        Double balanceDebitCard = null;
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
        return productQuantities;
    }
}
