package ru.clevertec.check;

import ru.clevertec.check.Dao.DiscountCardDAO;
import ru.clevertec.check.Dao.ProductDAO;
import ru.clevertec.check.Dao.ProductDAOImpl;
import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.entity.Product;
import ru.clevertec.check.service.DiscountCardService;
import ru.clevertec.check.service.ProductService;
import ru.clevertec.check.service.ProductServiceImpl;
import ru.clevertec.check.util.DiscountCardReaderCsv;
import ru.clevertec.check.util.ProductReaderCsv;

import java.util.HashMap;
import java.util.Map;

public class CheckRunner {
    public static void main(String[] args) {
        Map<Long, Product> productMap = new HashMap<>();

        ProductDAO productDAO = new ProductDAOImpl(productMap);
        ProductService productService = new ProductServiceImpl(productDAO);

        String csvFilePath = "src/main/resources/products.csv";
        ProductReaderCsv readerCsv = new ProductReaderCsv(productMap);
        readerCsv.loadProducts(csvFilePath);

        productService.getAllProducts().forEach(System.out::println);


        Map<Long, DiscountCard> discountCardMap = new HashMap<>();

        String discountSvFilePath = "src/main/resources/discountCards.csv";
        DiscountCardReaderCsv discountCardReaderCsv = new DiscountCardReaderCsv(discountCardMap);
        discountCardReaderCsv.loadDiscountCards(discountSvFilePath);

        DiscountCardDAO discountCardDAO = new DiscountCardDAO(discountCardMap);
        DiscountCardService discountCardService = new DiscountCardService(discountCardDAO);

        discountCardService.getAllDiscountCards().forEach(System.out::println);
    }
}
