package ru.clevertec.check;

import ru.clevertec.check.Dao.DiscountCardDAO;
import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.factory.FactoryGeneric;
import ru.clevertec.check.factory.FactoryService;
import ru.clevertec.check.service.DiscountCardService;
import ru.clevertec.check.service.ProductService;
import ru.clevertec.check.util.DiscountCardReaderCsv;
import ru.clevertec.check.util.ProductReaderCsv;
import ru.clevertec.check.util.ReaderAddressManager;

import java.util.Map;

public class CheckRunner {
    public static void main(String[] args) {

        ProductReaderCsv productReaderCsv = FactoryGeneric.getProductReaderCsv();
        String productsAddress = ReaderAddressManager.getProductsAddress();
        productReaderCsv.loadProducts(productsAddress);

        ProductService productService = FactoryService.getProductService();
        productService.getAllProducts().forEach(System.out::println);


        DiscountCardReaderCsv discountCardReaderCsv = FactoryGeneric.getDiscountCardReaderCsv();
        String discountCardsAddress = ReaderAddressManager.getDiscountCardsAddress();
        discountCardReaderCsv.loadDiscountCards(discountCardsAddress);
        DiscountCardService discountCardService = FactoryService.getDiscountCardService();

        discountCardService.getAllDiscountCards().forEach(System.out::println);
    }
}
