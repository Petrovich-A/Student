package by.petrovich.student.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PropertyLoaderTest {
    PropertyLoader propertyLoader = new PropertyLoader();

    @Test
    void receivePropertyValue() {
        String key = "connection.url";
        String expected = "jdbc:postgresql://localhost:5432/postgres";
        String actual = propertyLoader.receivePropertyValue(key);
        Assertions.assertEquals(expected, actual);
    }
}