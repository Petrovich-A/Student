package by.petrovich.student.controller;

import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.dao.impl.StudentDaoImpl;
import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.model.City;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/studentCreate")
public class StudentCreateServlet extends HttpServlet {
    private static final StudentDao STUDENT_DAO = new StudentDaoImpl();

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
        HttpSession session = request.getSession(true);
        List<City> cities = (List<City>) session.getAttribute("cities");
        String selectedCityName = request.getParameter("selectedCityName");
        City city = matchCityName(cities, selectedCityName);
        STUDENT_DAO.create(buildStudentDto(request, city));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/student");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
    protected City matchCityName(List<City> cities, String cityName) {
        return cities.stream().filter(city -> city.getName().equals(cityName)).findFirst().get();
    }

    private StudentDto buildStudentDto(HttpServletRequest request, City city) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String cityName = city.getName();
        int cityId = city.getId();
        return new StudentDto(firstName, lastName, cityName, cityId);
    }
}