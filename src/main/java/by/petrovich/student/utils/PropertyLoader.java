package by.petrovich.student.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private final String PROPERTY_PATH = "src/main/resources/properties/PostgreSQL-jdbc-config.properties";
    private final Properties PROPERTIES = new Properties();

    public String receivePropertyValue(String propertyKey) {
        readProperties(PROPERTY_PATH);
        return PROPERTIES.getProperty(propertyKey);
    }

    private void readProperties(String path) {
        try {
            InputStream inputStream = new FileInputStream(path);
            PROPERTIES.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
