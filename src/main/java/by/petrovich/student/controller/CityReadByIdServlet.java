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

import static by.petrovich.student.controller.RequestAttributeNames.CITY;
import static by.petrovich.student.controller.RequestAttributeNames.CITY_ID;


@WebServlet("/cityReadById")
public class CityReadByIdServlet extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter(CITY_ID));
        City city = CITY_SERVICE.readById(id);
        request.setAttribute(CITY, city);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/cityRead.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
