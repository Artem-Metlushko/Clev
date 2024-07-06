package ru.clevertec.check;

import ru.clevertec.check.dto.ArgumentParserDto;
import ru.clevertec.check.entity.Check;
import ru.clevertec.check.factory.FactoryGeneric;
import ru.clevertec.check.factory.FactoryService;
import ru.clevertec.check.service.ArgumentParserService;
import ru.clevertec.check.service.CheckService;
import ru.clevertec.check.util.DiscountCardReaderCsv;
import ru.clevertec.check.util.ProductReaderCsv;

import java.util.Map;




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

        Check checkFromCommandLine = getCheckFromCommandLine(argumentParser);
        Check check = getCheckAfterApplyDiscount(checkFromCommandLine);


//        Validator validator = FactoryGeneric.getValidator();
//        validator.validateBalance(balanceDebitCard, totalCost);
        CheckService checkService = FactoryService.getCheckService();
        checkService.printReceipt(check);

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
    private static Check getCheckFromCommandLine(ArgumentParserDto argumentParser){
        Check check = Check.builder().build();

        Long discountCardNumber = argumentParser.getDiscountCardNumber();
        check.setDiscountCardNumber(discountCardNumber);

        Double balanceDebitCard = argumentParser.getBalanceDebitCard();
        check.setBalanceDebitCard(balanceDebitCard);

        Map<Long, Integer> productQuantities = argumentParser.getProductQuantities();
        check.setProductQuantities(productQuantities);
        return check;
    }

    private static Check getCheckAfterApplyDiscount(Check checkFromCommandLine) {
        CheckService checkService = FactoryService.getCheckService();
        double sumTotalCost = checkService.getSumTotalCost(checkFromCommandLine);
        checkFromCommandLine.setTotalCost(sumTotalCost);
        return checkFromCommandLine;
    }

}
