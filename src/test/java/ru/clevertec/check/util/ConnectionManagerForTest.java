package ru.clevertec.check.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerForTest {
    private static String url = "jdbc:postgresql://localhost:54321/productstestdb";
    private static String username = "testuser";
    private static String password = "testpassword";

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


}
