package ru.clevertec.check;

import ru.clevertec.check.dto.ArgumentParserDto;
import ru.clevertec.check.entity.Check;
import ru.clevertec.check.factory.FactoryGeneric;
import ru.clevertec.check.factory.FactoryService;
import ru.clevertec.check.service.ArgumentParserService;
import ru.clevertec.check.service.CheckService;
import ru.clevertec.check.util.DiscountCardReaderCsv;
import ru.clevertec.check.util.ProductReaderCsv;
import ru.clevertec.check.validator.Validator;


public class CheckRunnerR {

    public static void main(String[] args) {

        loadDiscountCardFromCsv();

        ArgumentParserService argumentParserService = FactoryService.getArgumentParserService();
        ArgumentParserDto argumentParserDto = argumentParserService.parseArguments(args);

        loadProductFromCsv(argumentParserDto);

        CheckService checkService = FactoryService.getCheckService();
        Check checkFromCommandLine = checkService.getCheckFromCommandLine(argumentParserDto);

        Validator validator = FactoryGeneric.getValidator();
        validator.validateBalance(checkFromCommandLine);

        checkService.printReceipt(checkFromCommandLine);

        String saveToFile = argumentParserDto.getSaveToFile();
        checkService.writeReceiptToCsv(checkFromCommandLine,saveToFile);

    }

    private static void loadProductFromCsv(ArgumentParserDto argumentParserDto) {
        ProductReaderCsv productReaderCsv = FactoryGeneric.getProductReaderCsv();
        String pathToFile = argumentParserDto.getPathToFile();
        productReaderCsv.loadProducts(pathToFile);
    }



    private static void loadDiscountCardFromCsv() {
        DiscountCardReaderCsv discountCardReaderCsv = FactoryGeneric.getDiscountCardReaderCsv();
        String discountCardsAddress = "src/main/resources/discountCards.csv";
        discountCardReaderCsv.loadDiscountCards(discountCardsAddress);
    }



}
