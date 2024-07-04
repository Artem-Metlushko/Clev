package ru.clevertec.check.entity;

public class DiscountCard {

    private Long id;
    private String number;
    private Integer discountAmount;

    DiscountCard(Long id, String number, Integer discountAmount) {
        this.id = id;
        this.number = number;
        this.discountAmount = discountAmount;
    }

    public static DiscountCardBuilder builder() {
        return new DiscountCardBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getNumber() {
        return this.number;
    }

    public Integer getDiscountAmount() {
        return this.discountAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof DiscountCard)) return false;
        final DiscountCard other = (DiscountCard) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$number = this.getNumber();
        final Object other$number = other.getNumber();
        if (this$number == null ? other$number != null : !this$number.equals(other$number)) return false;
        final Object this$discountAmount = this.getDiscountAmount();
        final Object other$discountAmount = other.getDiscountAmount();
        if (this$discountAmount == null ? other$discountAmount != null : !this$discountAmount.equals(other$discountAmount))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DiscountCard;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $number = this.getNumber();
        result = result * PRIME + ($number == null ? 43 : $number.hashCode());
        final Object $discountAmount = this.getDiscountAmount();
        result = result * PRIME + ($discountAmount == null ? 43 : $discountAmount.hashCode());
        return result;
    }

    public String toString() {
        return "DiscountCard(id=" + this.getId() + ", number=" + this.getNumber() + ", discountAmount=" + this.getDiscountAmount() + ")";
    }

    public static class DiscountCardBuilder {
        private Long id;
        private String number;
        private Integer discountAmount;

        DiscountCardBuilder() {
        }

        public DiscountCardBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DiscountCardBuilder number(String number) {
            this.number = number;
            return this;
        }

        public DiscountCardBuilder discountAmount(Integer discountAmount) {
            this.discountAmount = discountAmount;
            return this;
        }

        public DiscountCard build() {
            return new DiscountCard(this.id, this.number, this.discountAmount);
        }

        public String toString() {
            return "DiscountCard.DiscountCardBuilder(id=" + this.id + ", number=" + this.number + ", discountAmount=" + this.discountAmount + ")";
        }
    }
}
