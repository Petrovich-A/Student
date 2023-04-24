package by.petrovich.student.controller;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.dao.impl.CityDaoImpl;
import by.petrovich.student.dao.impl.StudentDaoImpl;
import by.petrovich.student.model.City;
import by.petrovich.student.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.petrovich.student.controller.RequestAttributeNames.CITIES;
import static by.petrovich.student.controller.RequestAttributeNames.CITY_ID;
import static by.petrovich.student.controller.RequestAttributeNames.STUDENT;
import static by.petrovich.student.controller.RequestAttributeNames.STUDENT_ID;


@WebServlet("/goToUpdateStudentPage")
public class GoToUpdateStudentPageServlet extends HttpServlet {
    private static final StudentDao STUDENT_DAO = new StudentDaoImpl();
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
        int studentId = Integer.parseInt(request.getParameter(STUDENT_ID));
        int cityId = Integer.parseInt(request.getParameter(CITY_ID));
        Student student = STUDENT_DAO.readById(studentId);
        List<City> cities = CITY_DAO.receiveAll();
        request.setAttribute(STUDENT, student);
        request.setAttribute(CITIES, cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/studentUpdate.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}