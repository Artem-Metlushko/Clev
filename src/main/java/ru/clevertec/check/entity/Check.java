package ru.clevertec.check.entity;

public class Check {
    private Long id;
    private Integer quantity;
    private Integer discountCard;
    private Integer balanceDebitCard;

    Check(Long id, Integer quantity, Integer discountCard, Integer balanceDebitCard) {
        this.id = id;
        this.quantity = quantity;
        this.discountCard = discountCard;
        this.balanceDebitCard = balanceDebitCard;
    }

    public static CheckBuilder builder() {
        return new CheckBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Integer getDiscountCard() {
        return this.discountCard;
    }

    public Integer getBalanceDebitCard() {
        return this.balanceDebitCard;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDiscountCard(Integer discountCard) {
        this.discountCard = discountCard;
    }

    public void setBalanceDebitCard(Integer balanceDebitCard) {
        this.balanceDebitCard = balanceDebitCard;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Check)) return false;
        final Check other = (Check) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) return false;
        final Object this$discountCard = this.getDiscountCard();
        final Object other$discountCard = other.getDiscountCard();
        if (this$discountCard == null ? other$discountCard != null : !this$discountCard.equals(other$discountCard))
            return false;
        final Object this$balanceDebitCard = this.getBalanceDebitCard();
        final Object other$balanceDebitCard = other.getBalanceDebitCard();
        if (this$balanceDebitCard == null ? other$balanceDebitCard != null : !this$balanceDebitCard.equals(other$balanceDebitCard))
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
        final Object $quantity = this.getQuantity();
        result = result * PRIME + ($quantity == null ? 43 : $quantity.hashCode());
        final Object $discountCard = this.getDiscountCard();
        result = result * PRIME + ($discountCard == null ? 43 : $discountCard.hashCode());
        final Object $balanceDebitCard = this.getBalanceDebitCard();
        result = result * PRIME + ($balanceDebitCard == null ? 43 : $balanceDebitCard.hashCode());
        return result;
    }

    public String toString() {
        return "Check(id=" + this.getId() + ", quantity=" + this.getQuantity() + ", discountCard=" + this.getDiscountCard() + ", balanceDebitCard=" + this.getBalanceDebitCard() + ")";
    }

    public static class CheckBuilder {
        private Long id;
        private Integer quantity;
        private Integer discountCard;
        private Integer balanceDebitCard;

        CheckBuilder() {
        }

        public CheckBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CheckBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public CheckBuilder discountCard(Integer discountCard) {
            this.discountCard = discountCard;
            return this;
        }

        public CheckBuilder balanceDebitCard(Integer balanceDebitCard) {
            this.balanceDebitCard = balanceDebitCard;
            return this;
        }

        public Check build() {
            return new Check(this.id, this.quantity, this.discountCard, this.balanceDebitCard);
        }

        public String toString() {
            return "Check.CheckBuilder(id=" + this.id + ", quantity=" + this.quantity + ", discountCard=" + this.discountCard + ", balanceDebitCard=" + this.balanceDebitCard + ")";
        }
    }
}
