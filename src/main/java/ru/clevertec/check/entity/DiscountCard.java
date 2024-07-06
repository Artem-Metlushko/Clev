package ru.clevertec.check.entity;

public class DiscountCard {

    private Long id;
    private Long number;
    private Integer discountAmount;

    public DiscountCard(Long id, Long number, Integer discountAmount) {
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

    public Long getNumber() {
        return this.number;
    }

    public Integer getDiscountAmount() {
        return this.discountAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public static class DiscountCardBuilder {
        private Long id;
        private Long number;
        private Integer discountAmount;

        DiscountCardBuilder() {
        }

        public DiscountCardBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DiscountCardBuilder number(Long number) {
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
