package ru.clevertec.check.factory;

import lombok.experimental.UtilityClass;
import ru.clevertec.check.Dao.DiscountCardDAO;
import ru.clevertec.check.Dao.ProductDAO;

@UtilityClass
public class FactoryDao {

    private static DiscountCardDAO discountCardDAO;
    private static ProductDAO productDAO;


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
