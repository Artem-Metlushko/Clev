package ru.clevertec.check.factory;

import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.entity.Product;
import ru.clevertec.check.util.DiscountCardReaderCsv;
import ru.clevertec.check.util.ProductReaderCsv;
import ru.clevertec.check.validator.Validator;

import java.util.HashMap;
import java.util.Map;

public final class FactoryGeneric {

    private static Map<Long, DiscountCard> discountCardHashMap;
    private static Map<Long, Product> productMap;
    private static DiscountCardReaderCsv discountCardReaderCsv;
    private static ProductReaderCsv productReaderCsv;
    private static Validator validator;

    private FactoryGeneric() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static synchronized Map<Long, DiscountCard> getDiscountCardHashMap() {
        if (discountCardHashMap == null) {
            discountCardHashMap = new HashMap<>();
        }
        return discountCardHashMap;

    }

    public static synchronized Map<Long, Product> getProductHashMap() {
        if (productMap == null) {
            productMap = new HashMap<>();
        }
        return productMap;

    }

    public static synchronized DiscountCardReaderCsv getDiscountCardReaderCsv() {
        if (discountCardReaderCsv == null) {
            discountCardReaderCsv = new DiscountCardReaderCsv(getDiscountCardHashMap());
        }
        return discountCardReaderCsv;

    }

    public static synchronized ProductReaderCsv getProductReaderCsv() {
        if (productReaderCsv == null) {
            productReaderCsv = new ProductReaderCsv(getProductHashMap());
        }
        return productReaderCsv;

    }

    public static synchronized Validator getValidator() {
        if (validator == null) {
            validator = new Validator();
        }
        return validator;

    }

}
