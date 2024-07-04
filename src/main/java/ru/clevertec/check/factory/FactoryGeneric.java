package ru.clevertec.check.factory;

import lombok.experimental.UtilityClass;
import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.entity.Product;
import ru.clevertec.check.util.DiscountCardReaderCsv;
import ru.clevertec.check.util.ProductReaderCsv;
import ru.clevertec.check.util.ReaderAddressManager;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class FactoryGeneric {
    private static Map<Long, DiscountCard> discountCardHashMap;
    private static Map<Long, Product> productMap;
    private static DiscountCardReaderCsv discountCardReaderCsv;
    private static ProductReaderCsv productReaderCsv;


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




}
