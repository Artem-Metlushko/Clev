package ru.clevertec.check;

import ru.clevertec.check.dto.ArgumentParserDto;
import ru.clevertec.check.entity.Check;
import ru.clevertec.check.factory.FactoryGeneric;
import ru.clevertec.check.factory.FactoryService;
import ru.clevertec.check.service.ArgumentParserService;
import ru.clevertec.check.service.CheckService;
import ru.clevertec.check.util.DiscountCardReaderCsv;
import ru.clevertec.check.util.ProductReaderCsv;




public class CheckRunnerR {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java id-quantity discountCard=xxxx balanceDebitCard=xxxx");
            return;
        }

        loadProductFromCsv();
        loadDiscountCardFromCsv();


        ArgumentParserService argumentParserService = FactoryService.getArgumentParserService();
        ArgumentParserDto argumentParser = argumentParserService.parseArguments(args);

        CheckService checkService = FactoryService.getCheckService();

        Check checkFromCommandLine = checkService.getCheckFromCommandLine(argumentParser);



//        Validator validator = FactoryGeneric.getValidator();
//        validator.validateBalance(balanceDebitCard, totalCost);

        checkService.printReceipt(checkFromCommandLine);

    }


    private static void loadDiscountCardFromCsv() {
        DiscountCardReaderCsv discountCardReaderCsv = FactoryGeneric.getDiscountCardReaderCsv();
        String discountCardsAddress = "src/main/resources/discountCards.csv";
        discountCardReaderCsv.loadDiscountCards(discountCardsAddress);
    }

    private static void loadProductFromCsv() {
        ProductReaderCsv productReaderCsv = FactoryGeneric.getProductReaderCsv();
        String productsAddress = "src/main/resources/products.csv";
        productReaderCsv.loadProducts(productsAddress);
    }


}
