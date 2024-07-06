package ru.clevertec.check.util;


import ru.clevertec.check.dto.ArgumentParserDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            loadDriver();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDriver() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("org.postgresql.Driver");
    }


    public static Connection get() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void init(ArgumentParserDto argumentParserDto) {
        url = argumentParserDto.getDataSourceUrl();
        username = argumentParserDto.getDataSourceUserName();
        password=argumentParserDto.getDataSourcePassword();
    }

}
