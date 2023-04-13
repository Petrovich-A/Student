package by.petrovich.student.controller;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dao.impl.CityDaoImpl;
import by.petrovich.student.model.City;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/city")
public class CityServlet extends HttpServlet {
    private static final CityDao CITY_DAO = new CityDaoImpl();

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
        List<City> cities = CITY_DAO.receiveAll();
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/city.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
