package ru.clevertec.check.entity;

import java.util.Map;

public class Check {

    private Long id;
    private Long discountCardNumber;
    private double totalCost;
    private Double balanceDebitCard;
    private Map<Long, Integer> productQuantities;

    Check(Long id, Long discountCardNumber, double totalCost, Double balanceDebitCard, Map<Long, Integer> productQuantities) {
        this.id = id;
        this.discountCardNumber = discountCardNumber;
        this.totalCost = totalCost;
        this.balanceDebitCard = balanceDebitCard;
        this.productQuantities = productQuantities;
    }

    public static CheckBuilder builder() {
        return new CheckBuilder();
    }


    public Long getId() {
        return this.id;
    }

    public Long getDiscountCardNumber() {
        return this.discountCardNumber;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public Double getBalanceDebitCard() {
        return this.balanceDebitCard;
    }

    public Map<Long, Integer> getProductQuantities() {
        return this.productQuantities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDiscountCardNumber(Long discountCardNumber) {
        this.discountCardNumber = discountCardNumber;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setBalanceDebitCard(Double balanceDebitCard) {
        this.balanceDebitCard = balanceDebitCard;
    }

    public void setProductQuantities(Map<Long, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Check)) return false;
        final Check other = (Check) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$discountCardNumber = this.getDiscountCardNumber();
        final Object other$discountCardNumber = other.getDiscountCardNumber();
        if (this$discountCardNumber == null ? other$discountCardNumber != null : !this$discountCardNumber.equals(other$discountCardNumber))
            return false;
        if (Double.compare(this.getTotalCost(), other.getTotalCost()) != 0) return false;
        final Object this$balanceDebitCard = this.getBalanceDebitCard();
        final Object other$balanceDebitCard = other.getBalanceDebitCard();
        if (this$balanceDebitCard == null ? other$balanceDebitCard != null : !this$balanceDebitCard.equals(other$balanceDebitCard))
            return false;
        final Object this$productQuantities = this.getProductQuantities();
        final Object other$productQuantities = other.getProductQuantities();
        if (this$productQuantities == null ? other$productQuantities != null : !this$productQuantities.equals(other$productQuantities))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Check;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $discountCardNumber = this.getDiscountCardNumber();
        result = result * PRIME + ($discountCardNumber == null ? 43 : $discountCardNumber.hashCode());
        final long $totalCost = Double.doubleToLongBits(this.getTotalCost());
        result = result * PRIME + (int) ($totalCost >>> 32 ^ $totalCost);
        final Object $balanceDebitCard = this.getBalanceDebitCard();
        result = result * PRIME + ($balanceDebitCard == null ? 43 : $balanceDebitCard.hashCode());
        final Object $productQuantities = this.getProductQuantities();
        result = result * PRIME + ($productQuantities == null ? 43 : $productQuantities.hashCode());
        return result;
    }

    public String toString() {
        return "Check(id=" + this.getId() + ", discountCardNumber=" + this.getDiscountCardNumber() + ", totalCost=" + this.getTotalCost() + ", balanceDebitCard=" + this.getBalanceDebitCard() + ", productQuantities=" + this.getProductQuantities() + ")";
    }

    public static class CheckBuilder {
        private Long id;
        private Long discountCardNumber;
        private double totalCost;
        private Double balanceDebitCard;
        private Map<Long, Integer> productQuantities;

        CheckBuilder() {
        }

        public CheckBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CheckBuilder discountCardNumber(Long discountCardNumber) {
            this.discountCardNumber = discountCardNumber;
            return this;
        }

        public CheckBuilder totalCost(double totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public CheckBuilder balanceDebitCard(Double balanceDebitCard) {
            this.balanceDebitCard = balanceDebitCard;
            return this;
        }

        public CheckBuilder productQuantities(Map<Long, Integer> productQuantities) {
            this.productQuantities = productQuantities;
            return this;
        }

        public Check build() {
            return new Check(this.id, this.discountCardNumber, this.totalCost, this.balanceDebitCard, this.productQuantities);
        }

        public String toString() {
            return "Check.CheckBuilder(id=" + this.id + ", discountCardNumber=" + this.discountCardNumber + ", totalCost=" + this.totalCost + ", balanceDebitCard=" + this.balanceDebitCard + ", productQuantities=" + this.productQuantities + ")";
        }
    }
}
