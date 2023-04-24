package by.petrovich.student.controller;

import by.petrovich.student.dto.CityDto;
import by.petrovich.student.service.CityService;
import by.petrovich.student.service.impl.CityServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.petrovich.student.controller.RequestAttributeNames.CITY_NAME;


@WebServlet("/cityCreate")
public class CityCreateServlet extends HttpServlet {
    private static final CityService CITY_SERVICE = new CityServiceImpl();

    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter(CITY_NAME);
        CityDto cityDto = new CityDto();
        cityDto.setName(name);
        CITY_SERVICE.create(cityDto);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/goToCityPage");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
