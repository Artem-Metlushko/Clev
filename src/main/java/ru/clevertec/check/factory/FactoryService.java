package ru.clevertec.check.factory;


import ru.clevertec.check.service.ArgumentParserService;
import ru.clevertec.check.service.CheckService;
import ru.clevertec.check.service.DiscountCardService;
import ru.clevertec.check.service.ProductService;

public final class FactoryService {

    private static DiscountCardService discountCardService;
    private static ProductService productService;
    private static ArgumentParserService argumentParserService;
    private static CheckService checkService;

    private FactoryService() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }


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

    public static synchronized CheckService getCheckService() {
        if (checkService == null) {
            checkService = new CheckService(getDiscountCardService(),getProductService());
        }
        return checkService;
    }

    public static synchronized ArgumentParserService getArgumentParserService() {
        if (argumentParserService == null) {
            argumentParserService = new ArgumentParserService();
        }
        return argumentParserService;
    }



}
