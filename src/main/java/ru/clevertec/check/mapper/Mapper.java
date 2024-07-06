package ru.clevertec.check.mapper;

import ru.clevertec.check.dto.ArgumentParserDto;
import ru.clevertec.check.dto.ConnectionDto;

public class Mapper {
    public ConnectionDto getConnectionDto(ArgumentParserDto argumentParserDto){
        return ConnectionDto.builder()
                .dataSourceUrl(argumentParserDto.getDataSourceUrl())
                .dataSourceUserName(argumentParserDto.getDataSourceUserName())
                .dataSourcePassword(argumentParserDto.getDataSourcePassword())
                .build();

    }
}
