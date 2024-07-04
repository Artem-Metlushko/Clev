package ru.clevertec.check;

import ru.clevertec.check.factory.FactoryGeneric;
import ru.clevertec.check.factory.FactoryService;
import ru.clevertec.check.service.DiscountCardService;
import ru.clevertec.check.service.ProductService;
import ru.clevertec.check.util.DiscountCardReaderCsv;
import ru.clevertec.check.util.ProductReaderCsv;


public class CheckRunnerR {
    static {
        ProductReaderCsv productReaderCsv = FactoryGeneric.getProductReaderCsv();
        String productsAddress = "src/main/resources/products.csv";
        productReaderCsv.loadProducts(productsAddress);
        ProductService productService = FactoryService.getProductService();



        DiscountCardReaderCsv discountCardReaderCsv = FactoryGeneric.getDiscountCardReaderCsv();
        String discountCardsAddress = "src/main/resources/discountCards.csv";
        discountCardReaderCsv.loadDiscountCards(discountCardsAddress);
        DiscountCardService discountCardService = FactoryService.getDiscountCardService();

    }
    public static void main(String[] args) {

        System.out.printf("++++++++");
    }
}
