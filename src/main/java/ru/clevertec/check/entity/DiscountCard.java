package ru.clevertec.check.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DiscountCard {

    private Long id;
    private String number;
    private Integer discountAmount;

}
