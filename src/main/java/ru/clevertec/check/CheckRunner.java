package ru.clevertec.check;

import ru.clevertec.check.Dao.DiscountCardDAO;
import ru.clevertec.check.Dao.ProductDAO;
import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.entity.Product;
import ru.clevertec.check.factory.dao.FactoryDaoProduct;
import ru.clevertec.check.factory.generic.GenericFactory;
import ru.clevertec.check.service.DiscountCardService;
import ru.clevertec.check.service.ProductService;
import ru.clevertec.check.util.DiscountCardReaderCsv;
import ru.clevertec.check.util.ProductReaderCsv;
import ru.clevertec.check.util.ReaderAddressManager;

import java.util.Map;

public class CheckRunner {
    public static void main(String[] args) {
        Map<Long, Product> productMap = GenericFactory.getProductMap();

        FactoryDaoProduct factoryDaoProduct = new FactoryDaoProduct(productMap);
        ProductDAO productDao = (ProductDAO) factoryDaoProduct.createDao();
        ProductService productService = new ProductService(productDao);

        String productsAddress = ReaderAddressManager.getProductsAddress();
        ProductReaderCsv readerCsv = new ProductReaderCsv(productMap);
        readerCsv.loadProducts(productsAddress);

        productService.getAllProducts().forEach(System.out::println);


        Map<Long, DiscountCard> discountCardMap = GenericFactory.getDiscountCardMap();
        String discountSvFilePath = ReaderAddressManager.getDiscountCardsAddress();
        DiscountCardReaderCsv discountCardReaderCsv = new DiscountCardReaderCsv(discountCardMap);
        discountCardReaderCsv.loadDiscountCards(discountSvFilePath);

        DiscountCardDAO discountCardDAO = new DiscountCardDAO(discountCardMap);
        DiscountCardService discountCardService = new DiscountCardService(discountCardDAO);

        discountCardService.getAllDiscountCards().forEach(System.out::println);
    }
}
