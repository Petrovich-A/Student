package by.petrovich.student.utils;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class DatabaseConnector {
    private Connection connection;
    private final String JDBC_DRIVER_NAME = PropertyLoader.receivePropertyValue("jdbc.driver.name");
    private final String CONNECTION_URL = PropertyLoader.receivePropertyValue("connection.url");
    private final String USER_NAME = PropertyLoader.receivePropertyValue("user.name");
    private final String PASSWORD = PropertyLoader.receivePropertyValue("password");

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
