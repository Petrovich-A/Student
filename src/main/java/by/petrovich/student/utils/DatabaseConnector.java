package by.petrovich.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private Connection connection;
    private static final PropertyLoader PROPERTY_LOADER = new PropertyLoader();
    private static final String JDBC_DRIVER_NAME = PROPERTY_LOADER.receivePropertyValue("JDBC_DRIVER_NAME");
    private static final String CONNECTION_URL = PROPERTY_LOADER.receivePropertyValue("CONNECTION_URL");
    private static final String USER_NAME = PROPERTY_LOADER.receivePropertyValue("USER_NAME");
    private static final String PASSWORD = PROPERTY_LOADER.receivePropertyValue("PASSWORD");

    public Connection receiveConnection() {
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER_NAME);
                return DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

}
