package by.petrovich.student.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseConnectorTest {
    DatabaseConnector databaseConnector = new DatabaseConnector();

    @Test
    void receiveConnection()  {
        boolean isAvailable;
        try (Connection connection = databaseConnector.receiveConnection()) {
            isAvailable = connection.isValid(10);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertTrue(isAvailable);
    }
}