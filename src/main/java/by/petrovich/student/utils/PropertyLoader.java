package by.petrovich.student.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/properties/PostgreSQL-jdbc-config.properties")) {
            readProperties(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String receivePropertyValue(String propertyKey) {
        return PROPERTIES.getProperty(propertyKey);
    }

    private static void readProperties(FileInputStream fileInputStream) {
        try {
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
