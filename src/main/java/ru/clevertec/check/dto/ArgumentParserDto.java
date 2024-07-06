package ru.clevertec.check.dto;

import java.util.Map;

public class ArgumentParserDto {
    private Long discountCardNumber;
    private Double balanceDebitCard;
    private Map<Long, Integer> productQuantities;
    private String pathToFile;
    private String saveToFile;

    ArgumentParserDto(Long discountCardNumber, Double balanceDebitCard, Map<Long, Integer> productQuantities, String pathToFile, String saveToFile) {
        this.discountCardNumber = discountCardNumber;
        this.balanceDebitCard = balanceDebitCard;
        this.productQuantities = productQuantities;
        this.pathToFile = pathToFile;
        this.saveToFile = saveToFile;
    }

    public static ArgumentParserDtoBuilder builder() {
        return new ArgumentParserDtoBuilder();
    }

    public Long getDiscountCardNumber() {
        return this.discountCardNumber;
    }

    public Double getBalanceDebitCard() {
        return this.balanceDebitCard;
    }

    public Map<Long, Integer> getProductQuantities() {
        return this.productQuantities;
    }

    public String getPathToFile() {
        return this.pathToFile;
    }

    public String getSaveToFile() {
        return this.saveToFile;
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

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void setSaveToFile(String saveToFile) {
        this.saveToFile = saveToFile;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ArgumentParserDto)) return false;
        final ArgumentParserDto other = (ArgumentParserDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$discountCardNumber = this.getDiscountCardNumber();
        final Object other$discountCardNumber = other.getDiscountCardNumber();
        if (this$discountCardNumber == null ? other$discountCardNumber != null : !this$discountCardNumber.equals(other$discountCardNumber))
            return false;
        final Object this$balanceDebitCard = this.getBalanceDebitCard();
        final Object other$balanceDebitCard = other.getBalanceDebitCard();
        if (this$balanceDebitCard == null ? other$balanceDebitCard != null : !this$balanceDebitCard.equals(other$balanceDebitCard))
            return false;
        final Object this$productQuantities = this.getProductQuantities();
        final Object other$productQuantities = other.getProductQuantities();
        if (this$productQuantities == null ? other$productQuantities != null : !this$productQuantities.equals(other$productQuantities))
            return false;
        final Object this$pathToFile = this.getPathToFile();
        final Object other$pathToFile = other.getPathToFile();
        if (this$pathToFile == null ? other$pathToFile != null : !this$pathToFile.equals(other$pathToFile))
            return false;
        final Object this$saveToFile = this.getSaveToFile();
        final Object other$saveToFile = other.getSaveToFile();
        if (this$saveToFile == null ? other$saveToFile != null : !this$saveToFile.equals(other$saveToFile))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ArgumentParserDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $discountCardNumber = this.getDiscountCardNumber();
        result = result * PRIME + ($discountCardNumber == null ? 43 : $discountCardNumber.hashCode());
        final Object $balanceDebitCard = this.getBalanceDebitCard();
        result = result * PRIME + ($balanceDebitCard == null ? 43 : $balanceDebitCard.hashCode());
        final Object $productQuantities = this.getProductQuantities();
        result = result * PRIME + ($productQuantities == null ? 43 : $productQuantities.hashCode());
        final Object $pathToFile = this.getPathToFile();
        result = result * PRIME + ($pathToFile == null ? 43 : $pathToFile.hashCode());
        final Object $saveToFile = this.getSaveToFile();
        result = result * PRIME + ($saveToFile == null ? 43 : $saveToFile.hashCode());
        return result;
    }

    public String toString() {
        return "ArgumentParserDto(discountCardNumber=" + this.getDiscountCardNumber() + ", balanceDebitCard=" + this.getBalanceDebitCard() + ", productQuantities=" + this.getProductQuantities() + ", pathToFile=" + this.getPathToFile() + ", saveToFile=" + this.getSaveToFile() + ")";
    }

    public static class ArgumentParserDtoBuilder {
        private Long discountCardNumber;
        private Double balanceDebitCard;
        private Map<Long, Integer> productQuantities;
        private String pathToFile;
        private String saveToFile;

        ArgumentParserDtoBuilder() {
        }

        public ArgumentParserDtoBuilder discountCardNumber(Long discountCardNumber) {
            this.discountCardNumber = discountCardNumber;
            return this;
        }

        public ArgumentParserDtoBuilder balanceDebitCard(Double balanceDebitCard) {
            this.balanceDebitCard = balanceDebitCard;
            return this;
        }

        public ArgumentParserDtoBuilder productQuantities(Map<Long, Integer> productQuantities) {
            this.productQuantities = productQuantities;
            return this;
        }

        public ArgumentParserDtoBuilder pathToFile(String pathToFile) {
            this.pathToFile = pathToFile;
            return this;
        }

        public ArgumentParserDtoBuilder saveToFile(String saveToFile) {
            this.saveToFile = saveToFile;
            return this;
        }

        public ArgumentParserDto build() {
            return new ArgumentParserDto(this.discountCardNumber, this.balanceDebitCard, this.productQuantities, this.pathToFile, this.saveToFile);
        }

        public String toString() {
            return "ArgumentParserDto.ArgumentParserDtoBuilder(discountCardNumber=" + this.discountCardNumber + ", balanceDebitCard=" + this.balanceDebitCard + ", productQuantities=" + this.productQuantities + ", pathToFile=" + this.pathToFile + ", saveToFile=" + this.saveToFile + ")";
        }
    }
}
