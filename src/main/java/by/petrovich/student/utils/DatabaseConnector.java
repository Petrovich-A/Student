package by.petrovich.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final PropertyLoader PROPERTY_LOADER = new PropertyLoader();
    private static final String JDBC_DRIVER_NAME = PROPERTY_LOADER.receivePropertyValue("JDBC_DRIVER_NAME");
    private static final String CONNECTION_URL = PROPERTY_LOADER.receivePropertyValue("CONNECTION_URL");
    private static final String USER_NAME = PROPERTY_LOADER.receivePropertyValue("USER_NAME");
    private static final String PASSWORD = PROPERTY_LOADER.receivePropertyValue("PASSWORD");

    public Connection receiveConnection() {
        try {
            Class.forName(JDBC_DRIVER_NAME);
            return DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
