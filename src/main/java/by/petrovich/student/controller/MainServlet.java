package by.petrovich.student.controller;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dao.impl.CityDaoImpl;
import by.petrovich.student.model.City;
import by.petrovich.student.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
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
        Map<City, List<Student>> cityListStudent = new HashMap<>();
        request.setAttribute("cityListStudent", cityListStudent);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
