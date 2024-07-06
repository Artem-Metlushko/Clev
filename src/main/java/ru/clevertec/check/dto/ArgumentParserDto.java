package ru.clevertec.check.dto;

import java.util.Map;

public class ArgumentParserDto {
    private Long discountCardNumber;
    private Double balanceDebitCard;
    private Map<Long, Integer> productQuantities;
    private String saveToFile;
    private String dataSourceUrl;
    private String dataSourceUserName;
    private String dataSourcePassword;

    ArgumentParserDto(Long discountCardNumber, Double balanceDebitCard, Map<Long, Integer> productQuantities, String saveToFile, String dataSourceUrl, String dataSourceUserName, String dataSourcePassword) {
        this.discountCardNumber = discountCardNumber;
        this.balanceDebitCard = balanceDebitCard;
        this.productQuantities = productQuantities;
        this.saveToFile = saveToFile;
        this.dataSourceUrl = dataSourceUrl;
        this.dataSourceUserName = dataSourceUserName;
        this.dataSourcePassword = dataSourcePassword;
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

    public String getSaveToFile() {
        return this.saveToFile;
    }

    public String getDataSourceUrl() {
        return this.dataSourceUrl;
    }

    public String getDataSourceUserName() {
        return this.dataSourceUserName;
    }

    public String getDataSourcePassword() {
        return this.dataSourcePassword;
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

    public void setSaveToFile(String saveToFile) {
        this.saveToFile = saveToFile;
    }

    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
    }

    public void setDataSourceUserName(String dataSourceUserName) {
        this.dataSourceUserName = dataSourceUserName;
    }

    public void setDataSourcePassword(String dataSourcePassword) {
        this.dataSourcePassword = dataSourcePassword;
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
        final Object this$saveToFile = this.getSaveToFile();
        final Object other$saveToFile = other.getSaveToFile();
        if (this$saveToFile == null ? other$saveToFile != null : !this$saveToFile.equals(other$saveToFile))
            return false;
        final Object this$dataSourceUrl = this.getDataSourceUrl();
        final Object other$dataSourceUrl = other.getDataSourceUrl();
        if (this$dataSourceUrl == null ? other$dataSourceUrl != null : !this$dataSourceUrl.equals(other$dataSourceUrl))
            return false;
        final Object this$dataSourceUserName = this.getDataSourceUserName();
        final Object other$dataSourceUserName = other.getDataSourceUserName();
        if (this$dataSourceUserName == null ? other$dataSourceUserName != null : !this$dataSourceUserName.equals(other$dataSourceUserName))
            return false;
        final Object this$dataSourcePassword = this.getDataSourcePassword();
        final Object other$dataSourcePassword = other.getDataSourcePassword();
        if (this$dataSourcePassword == null ? other$dataSourcePassword != null : !this$dataSourcePassword.equals(other$dataSourcePassword))
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
        final Object $saveToFile = this.getSaveToFile();
        result = result * PRIME + ($saveToFile == null ? 43 : $saveToFile.hashCode());
        final Object $dataSourceUrl = this.getDataSourceUrl();
        result = result * PRIME + ($dataSourceUrl == null ? 43 : $dataSourceUrl.hashCode());
        final Object $dataSourceUserName = this.getDataSourceUserName();
        result = result * PRIME + ($dataSourceUserName == null ? 43 : $dataSourceUserName.hashCode());
        final Object $dataSourcePassword = this.getDataSourcePassword();
        result = result * PRIME + ($dataSourcePassword == null ? 43 : $dataSourcePassword.hashCode());
        return result;
    }

    public String toString() {
        return "ArgumentParserDto(discountCardNumber=" + this.getDiscountCardNumber() + ", balanceDebitCard=" + this.getBalanceDebitCard() + ", productQuantities=" + this.getProductQuantities() + ", saveToFile=" + this.getSaveToFile() + ", dataSourceUrl=" + this.getDataSourceUrl() + ", dataSourceUserName=" + this.getDataSourceUserName() + ", dataSourcePassword=" + this.getDataSourcePassword() + ")";
    }

    public static class ArgumentParserDtoBuilder {
        private Long discountCardNumber;
        private Double balanceDebitCard;
        private Map<Long, Integer> productQuantities;
        private String saveToFile;
        private String dataSourceUrl;
        private String dataSourceUserName;
        private String dataSourcePassword;

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

        public ArgumentParserDtoBuilder saveToFile(String saveToFile) {
            this.saveToFile = saveToFile;
            return this;
        }

        public ArgumentParserDtoBuilder dataSourceUrl(String dataSourceUrl) {
            this.dataSourceUrl = dataSourceUrl;
            return this;
        }

        public ArgumentParserDtoBuilder dataSourceUserName(String dataSourceUserName) {
            this.dataSourceUserName = dataSourceUserName;
            return this;
        }

        public ArgumentParserDtoBuilder dataSourcePassword(String dataSourcePassword) {
            this.dataSourcePassword = dataSourcePassword;
            return this;
        }

        public ArgumentParserDto build() {
            return new ArgumentParserDto(this.discountCardNumber, this.balanceDebitCard, this.productQuantities, this.saveToFile, this.dataSourceUrl, this.dataSourceUserName, this.dataSourcePassword);
        }

        public String toString() {
            return "ArgumentParserDto.ArgumentParserDtoBuilder(discountCardNumber=" + this.discountCardNumber + ", balanceDebitCard=" + this.balanceDebitCard + ", productQuantities=" + this.productQuantities + ", saveToFile=" + this.saveToFile + ", dataSourceUrl=" + this.dataSourceUrl + ", dataSourceUserName=" + this.dataSourceUserName + ", dataSourcePassword=" + this.dataSourcePassword + ")";
        }
    }
}
