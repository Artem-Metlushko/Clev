package ru.clevertec.check;

import ru.clevertec.check.dto.ArgumentParserDto;
import ru.clevertec.check.service.ArgumentParserService;
import ru.clevertec.check.util.ConnectionManager;
import ru.clevertec.check.util.DatabaseInitializerUtil;


public class CheckRunnerR {

    public static void main(String[] args) {

        ArgumentParserDto argumentParserDto = ArgumentParserService.parseArguments(args);
        System.out.println(argumentParserDto.getDataSourceUrl());
        ConnectionManager.init(argumentParserDto);
        DatabaseInitializerUtil.runSqlScripts();


    }




}
