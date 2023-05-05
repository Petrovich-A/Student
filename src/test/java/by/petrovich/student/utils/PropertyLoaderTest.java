package by.petrovich.student.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PropertyLoaderTest {

    @Test
    void receivePropertyValue() {
        String key = "connection.url";
        String expected = "jdbc:postgresql://localhost:5432/postgres";
        String actual = PropertyLoader.receivePropertyValue(key);
        Assertions.assertEquals(expected, actual);
    }
}