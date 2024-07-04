package ru.clevertec.check.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Product {
    private long id;
    private String description;
    private Double price;
    private int quantity;
    private boolean wholesale;
}
