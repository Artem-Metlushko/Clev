package ru.clevertec.check.service;

import ru.clevertec.check.dto.ArgumentParserDto;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParserService {

    public ArgumentParserDto parseArguments(String[] args) {
        ArgumentParserDto argumentParser = ArgumentParserDto.builder()
                .build();
        Map<Long, Integer> productQuantities = new HashMap<>();
        for (String arg : args) {
            if (arg.startsWith("discountCard=")) {
                long discountCardNumber = Long.parseLong(arg.split("=")[1]);
                argumentParser.setDiscountCardNumber(discountCardNumber);
            } else if (arg.startsWith("balanceDebitCard=")) {
                double balance = Double.parseDouble(arg.split("=")[1]);
                argumentParser.setBalanceDebitCard(balance);
            } else if (arg.startsWith("pathToFile=")) {
                String pathToFile = arg.split("=")[1];
                argumentParser.setPathToFile(pathToFile);
            } else if (arg.startsWith("saveToFile=")) {
                String saveToFile = arg.split("=")[1];
                argumentParser.setSaveToFile(saveToFile);
            } else {
                String[] parts = arg.split("-");
                Long productId = Long.parseLong(parts[0]);
                Integer quantity = Integer.parseInt(parts[1]);
                productQuantities.put(productId, quantity);
                argumentParser.setProductQuantities(productQuantities);
            }
        }
        return argumentParser;
    }
}
