package ru.clevertec.check.factory;


import lombok.experimental.UtilityClass;
import ru.clevertec.check.service.DiscountCardService;
import ru.clevertec.check.service.ProductService;

@UtilityClass
public class FactoryService {

    private static DiscountCardService discountCardService;
    private static ProductService productService;


    public static synchronized DiscountCardService getDiscountCardService() {
        if (discountCardService == null) {
            discountCardService = new DiscountCardService(FactoryDao.getDiscountCardDAO());
        }
        return discountCardService;

    }

    public static synchronized ProductService getProductService() {
        if (productService == null) {
            productService = new ProductService(FactoryDao.getProductDAO());
        }
        return productService;
    }

}
