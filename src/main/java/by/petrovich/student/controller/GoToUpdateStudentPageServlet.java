package by.petrovich.student.controller;

import by.petrovich.student.model.City;
import by.petrovich.student.model.Student;
import by.petrovich.student.service.CityService;
import by.petrovich.student.service.StudentService;
import by.petrovich.student.service.impl.CityServiceImpl;
import by.petrovich.student.service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.petrovich.student.controller.RequestAttributeNames.CITIES;
import static by.petrovich.student.controller.RequestAttributeNames.STUDENT;
import static by.petrovich.student.controller.RequestAttributeNames.STUDENT_ID;


@WebServlet("/goToUpdateStudentPage")
public class GoToUpdateStudentPageServlet extends HttpServlet {
    private static final CityService CITY_SERVICE = new CityServiceImpl();
    private static final StudentService STUDENT_SERVICE = new StudentServiceImpl();

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
        Student student = STUDENT_SERVICE.readById(studentId);
        List<City> cities = CITY_SERVICE.receiveAll();
        request.setAttribute(STUDENT, student);
        request.setAttribute(CITIES, cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/studentUpdate.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
