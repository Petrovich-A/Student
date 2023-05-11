package by.petrovich.student.service.impl;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dao.impl.CityDaoImpl;
import by.petrovich.student.dto.CityDto;
import by.petrovich.student.model.City;
import by.petrovich.student.service.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {
    private static final CityDao CITY_DAO = new CityDaoImpl();

    @Override
    public List<City> receiveAll() {
        return CITY_DAO.receiveAll();
    }

    @Override
    public City readById(int id) {
        return CITY_DAO.readById(id);
    }

    @Override
    public void deleteById(int id) {
        CITY_DAO.deleteById(id);
    }

    @Override
    public void updateById(CityDto cityDto) {
        City city = City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .build();
        CITY_DAO.updateById(city);
    }

    @Override
    public void create(CityDto cityDto) {
        City city = City.builder()
                .name(cityDto.getName())
                .build();
        CITY_DAO.create(city);
    }
}
