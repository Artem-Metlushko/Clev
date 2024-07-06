package ru.clevertec.check.dto;

import java.util.Map;

public class ArgumentParserDto {
    private Long discountCardNumber;
    private Double balanceDebitCard;
    private Map<Long, Integer> productQuantities;

    ArgumentParserDto(Long discountCardNumber, Double balanceDebitCard, Map<Long, Integer> productQuantities) {
        this.discountCardNumber = discountCardNumber;
        this.balanceDebitCard = balanceDebitCard;
        this.productQuantities = productQuantities;
    }

    public static ArgumentParserBuilder builder() {
        return new ArgumentParserBuilder();
    }

    public Long getDiscountCardNumber() {
        return discountCardNumber;
    }

    public Double getBalanceDebitCard() {
        return balanceDebitCard;
    }

    public Map<Long, Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setDiscountCardNumber(Long discountCardNumber) {
        this.discountCardNumber = discountCardNumber;
    }

    public void setBalanceDebitCard(Double balanceDebitCard) {
        this.balanceDebitCard = balanceDebitCard;
    }

    public void setProductQuantities(Map<Long, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public static class ArgumentParserBuilder {
        private Long discountCardNumber;
        private Double balanceDebitCard;
        private Map<Long, Integer> productQuantities;

        ArgumentParserBuilder() {
        }

        public ArgumentParserBuilder discountCardNumber(Long discountCardNumber) {
            this.discountCardNumber = discountCardNumber;
            return this;
        }

        public ArgumentParserBuilder balanceDebitCard(Double balanceDebitCard) {
            this.balanceDebitCard = balanceDebitCard;
            return this;
        }

        public ArgumentParserBuilder productQuantities(Map<Long, Integer> productQuantities) {
            this.productQuantities = productQuantities;
            return this;
        }

        public ArgumentParserDto build() {
            return new ArgumentParserDto(this.discountCardNumber, this.balanceDebitCard, this.productQuantities);
        }

        public String toString() {
            return "ArgumentParser.ArgumentParserBuilder(discountCardNumber=" + this.discountCardNumber + ", balanceDebitCard=" + this.balanceDebitCard + ", productQuantities=" + this.productQuantities + ")";
        }
    }
}
