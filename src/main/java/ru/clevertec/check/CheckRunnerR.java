package ru.clevertec.check;

import ru.clevertec.check.util.DatabaseInitializerUtil;


public class CheckRunnerR {

    public static void main(String[] args) {

//        ArgumentParserDto argumentParserDto = ArgumentParserService.parseArguments(args);
//        ConnectionManager.init(argumentParserDto);
        DatabaseInitializerUtil.runSqlScripts();


    }




}
