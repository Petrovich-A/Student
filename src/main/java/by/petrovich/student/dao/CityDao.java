package by.petrovich.student.dao;

import by.petrovich.student.model.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CityDao {
    List<City> receiveAll();

    City buildCity(ResultSet resultSet) throws SQLException;
}
