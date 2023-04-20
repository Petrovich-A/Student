package by.petrovich.student.dao.impl;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dto.CityUpdateDto;
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
    private final String INSERT = "INSERT INTO cities (name) VALUES (?)";
    private final String FROM = "FROM cities ";
    private final String DELETE = "DELETE ";
    private final String UPDATE = "UPDATE cities SET name = ? ";
    private final String WHERE_NAME = "WHERE name = ?";
    private final String WHERE_ID = "WHERE city_id = ?";

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

    @Override
    public City readById(int id) {
        City city = new City();
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + FROM + WHERE_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                city = buildCity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return city;
    }

    @Override
    public void deleteById(int id) {
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE + FROM + WHERE_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(CityUpdateDto cityUpdateDto) {
        try (Connection connection = databaseConnector.receiveConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE + WHERE_ID)) {
            preparedStatement.setString(1, cityUpdateDto.getName());
            preparedStatement.setInt(2, cityUpdateDto.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void create(City city) {
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private City buildCity(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt(CITY_ID));
        city.setName(resultSet.getString(NAME));
        return city;
    }

}
