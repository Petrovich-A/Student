package by.petrovich.student.controller;

import by.petrovich.student.model.City;
import by.petrovich.student.service.CityService;
import by.petrovich.student.service.impl.CityServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITIES;

@WebServlet("/go-to-city-page")
public class GoToCityPageServlet extends HttpServlet {
    private final CityService CITY_SERVICE = new CityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<City> cities = CITY_SERVICE.receiveAll();
        request.setAttribute(CITIES, cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/city.jsp");
        requestDispatcher.forward(request, response);
    }

}