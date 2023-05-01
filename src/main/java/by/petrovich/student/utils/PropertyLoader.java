package by.petrovich.student.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private final static String PROPERTY_PATH = "properties/application.properties";
    private final static Logger LOGGER = LogManager.getLogger();
    private final static Properties PROPERTIES = new Properties();

    public String receivePropertyValue(String propertyKey) {
        readProperties();
        return PROPERTIES.getProperty(propertyKey);
    }

    private void readProperties() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTY_PATH)) {
            if (inputStream != null) {
                PROPERTIES.load(inputStream);
            } else {
                LOGGER.log(Level.FATAL, "Property file: \"{}\" does not exist", PROPERTY_PATH);
                throw new FileNotFoundException("Property file not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}