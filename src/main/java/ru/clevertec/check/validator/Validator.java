package ru.clevertec.check.validator;


import ru.clevertec.check.entity.Check;

public class Validator {
    public void validateBalance(Check check) {
        Double balanceDebitCard = check.getBalanceDebitCard();
        if (balanceDebitCard == null) {
            throw new IllegalArgumentException("Error: balanceDebitCard parameter is required.");
        }

        double totalCost = check.getTotalCost();
        if (balanceDebitCard < totalCost) {
            throw new IllegalArgumentException("Error: Insufficient balance on debit card.");
        }
    }
}

