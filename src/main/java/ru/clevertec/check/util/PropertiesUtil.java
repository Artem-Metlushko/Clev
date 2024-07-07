package ru.clevertec.check.util;


import ru.clevertec.check.exception.PropertiesLoadException;

import java.io.IOException;
import java.util.Properties;


public final class PropertiesUtil {
    private static Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);

    }

    private static void loadProperties() {
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new PropertiesLoadException("Error loading properties from application.properties", e);
        }
    }


}
