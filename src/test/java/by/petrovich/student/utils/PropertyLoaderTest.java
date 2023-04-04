package by.petrovich.student.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PropertyLoaderTest {
    PropertyLoader propertyLoader = new PropertyLoader();

    @Test
    void receivePropertyValue() {
        String key = "USER_NAME";
        String expected = "postgres";
        String actual = propertyLoader.receivePropertyValue(key);
        Assertions.assertEquals(expected, actual);
    }
}