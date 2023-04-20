package by.petrovich.student.controller;

import by.petrovich.student.model.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StudentCreateServletTest {
    StudentCreateServlet studentCreateServlet = new StudentCreateServlet();

    @Test
    void matchCityName() {
        City city1 = new City(1, "JH");
        City city2 = new City(2, "GG");
        List<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        String name = "GG";
        Assertions.assertEquals(city2, studentCreateServlet.matchCityName(cities, name));


    }
}