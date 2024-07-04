package ru.clevertec.check.entity;

public class Product {
    private long id;
    private String description;
    private Double price;
    private int quantity;
    private boolean wholesale;

    Product(long id, String description, Double price, int quantity, boolean wholesale) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.wholesale = wholesale;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public boolean isWholesale() {
        return this.wholesale;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWholesale(boolean wholesale) {
        this.wholesale = wholesale;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) return false;
        final Product other = (Product) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        if (this.getQuantity() != other.getQuantity()) return false;
        if (this.isWholesale() != other.isWholesale()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Product;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        result = result * PRIME + this.getQuantity();
        result = result * PRIME + (this.isWholesale() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "Product(id=" + this.getId() + ", description=" + this.getDescription() + ", price=" + this.getPrice() + ", quantity=" + this.getQuantity() + ", wholesale=" + this.isWholesale() + ")";
    }

    public static class ProductBuilder {
        private long id;
        private String description;
        private Double price;
        private int quantity;
        private boolean wholesale;

        ProductBuilder() {
        }

        public ProductBuilder id(long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder wholesale(boolean wholesale) {
            this.wholesale = wholesale;
            return this;
        }

        public Product build() {
            return new Product(this.id, this.description, this.price, this.quantity, this.wholesale);
        }

        public String toString() {
            return "Product.ProductBuilder(id=" + this.id + ", description=" + this.description + ", price=" + this.price + ", quantity=" + this.quantity + ", wholesale=" + this.wholesale + ")";
        }
    }
}
