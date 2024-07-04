package ru.clevertec.check.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ReaderAddressManager {

    private static final String DISCOUNT_CARDS_CSV = "discountCards.csv";
    private static final String PRODUCTS_CSV = "products.csv";

    public static String getDiscountCardsAddress() {
        return PropertiesUtil.get(DISCOUNT_CARDS_CSV);
    }

    public static String getProductsAddress(){
        return PropertiesUtil.get(PRODUCTS_CSV);
    }
}
