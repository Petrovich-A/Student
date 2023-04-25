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

import static by.petrovich.student.controller.RequestAttributeNames.CITIES;


@WebServlet("/goToCreateStudentPage")
public class GoToCreateStudentPageServlet extends HttpServlet {
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/studentCreate.jsp");
        List<City> cities = CITY_SERVICE.receiveAll();
        request.setAttribute(CITIES, cities);
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
