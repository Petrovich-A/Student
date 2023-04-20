package by.petrovich.student.dao;

import by.petrovich.student.dto.CityUpdateDto;
import by.petrovich.student.model.City;

import java.util.List;

public interface CityDao {
    List<City> receiveAll();

    City readById(int id);

    void deleteById(int id);

    void updateById(CityUpdateDto cityUpdateDto);

    void create(City city);

}
