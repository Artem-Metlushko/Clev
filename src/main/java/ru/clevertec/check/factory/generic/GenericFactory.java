package ru.clevertec.check.factory.generic;

import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.entity.Product;

import java.util.HashMap;
import java.util.Map;

public class GenericFactory {
    public static HashMap<Long, DiscountCard> longDiscountCardHashMap = new HashMap<>();
    public static HashMap<Long, Product> longProductHashMap = new HashMap<>();

    public static Map<Long, DiscountCard> getDiscountCardMap() {
        return longDiscountCardHashMap;
    }

    public static Map<Long, Product> getProductMap() {
        return longProductHashMap;
    }

}
