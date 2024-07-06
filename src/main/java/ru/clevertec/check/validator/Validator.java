package ru.clevertec.check.validator;


public class Validator {
    public void validateBalance(Double balanceDebitCard, double totalCost) {
        if (balanceDebitCard == null) {
            throw new IllegalArgumentException("Error: balanceDebitCard parameter is required.");
        }
        if (balanceDebitCard < totalCost) {
            throw new IllegalArgumentException("Error: Insufficient balance on debit card.");
        }
    }
}

