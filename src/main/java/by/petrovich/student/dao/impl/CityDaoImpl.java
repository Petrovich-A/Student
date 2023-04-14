package by.petrovich.student.dao.impl;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.model.City;
import by.petrovich.student.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.petrovich.student.dao.FieldName.CITY_ID;
import static by.petrovich.student.dao.FieldName.NAME;

public class CityDaoImpl implements CityDao {
    private final String SELECT_ALL = "SELECT city_id, name ";
    private final String FROM = "FROM cities";
    private final DatabaseConnector databaseConnector = new DatabaseConnector();

    @Override
    public List<City> receiveAll() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + FROM);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                cities.add(buildCity(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

    public City buildCity(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt(CITY_ID));
        city.setName(resultSet.getString(NAME));
        return city;
    }

}
