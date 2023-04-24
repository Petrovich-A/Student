package by.petrovich.student.service;

import by.petrovich.student.dto.CityDto;
import by.petrovich.student.model.City;

import java.util.List;

public interface CityService {
    List<City> receiveAll();

    City readById(int id);

    void deleteById(int id);

    void updateById(CityDto cityDto);

    void create(CityDto cityDto);

}
