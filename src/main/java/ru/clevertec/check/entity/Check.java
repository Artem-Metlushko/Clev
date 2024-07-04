package ru.clevertec.check.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Check {
    private Long id;
    private Integer quantity;
    private Integer discountCard;
    private Integer balanceDebitCard;
}
