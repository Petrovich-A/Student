package by.petrovich.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private Connection connection;
    private static final PropertyLoader PROPERTY_LOADER = new PropertyLoader();
    private static final String JDBC_DRIVER_NAME = PROPERTY_LOADER.receivePropertyValue("jdbc.driver.name");
    private static final String CONNECTION_URL = PROPERTY_LOADER.receivePropertyValue("connection.url");
    private static final String USER_NAME = PROPERTY_LOADER.receivePropertyValue("user.name");
    private static final String PASSWORD = PROPERTY_LOADER.receivePropertyValue("password");

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
