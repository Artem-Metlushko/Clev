package ru.clevertec.check.factory;

import ru.clevertec.check.dao.DiscountCardDAO;
import ru.clevertec.check.dao.ProductDAO;

public final class FactoryDao {

    private static DiscountCardDAO discountCardDAO;
    private static ProductDAO productDAO;

    private FactoryDao() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }


    public static synchronized DiscountCardDAO getDiscountCardDAO() {
        if (discountCardDAO == null) {
            discountCardDAO = new DiscountCardDAO(FactoryGeneric.getDiscountCardHashMap());
        }
        return discountCardDAO;
    }

    public static synchronized ProductDAO getProductDAO() {
        if (productDAO == null) {
            productDAO = new ProductDAO(FactoryGeneric.getProductHashMap());
        }
        return productDAO;
    }

}
