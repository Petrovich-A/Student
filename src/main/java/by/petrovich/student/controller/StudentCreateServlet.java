package by.petrovich.student.controller;

import by.petrovich.student.dto.CityDto;
import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.service.StudentService;
import by.petrovich.student.service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.petrovich.student.controller.RequestAttributeNames.CITY_ID;
import static by.petrovich.student.controller.RequestAttributeNames.STUDENT_FIRST_NAME;
import static by.petrovich.student.controller.RequestAttributeNames.STUDENT_LAST_NAME;


@WebServlet("/studentCreate")
public class StudentCreateServlet extends HttpServlet {
    private static final StudentService STUDENT_SERVICE = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        STUDENT_SERVICE.create(buildStudentDto(request));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/goToStudentPage");
        dispatcher.forward(request, response);
    }

    private StudentDto buildStudentDto(HttpServletRequest request) {
        String firstName = request.getParameter(STUDENT_FIRST_NAME);
        String lastName = request.getParameter(STUDENT_LAST_NAME);
        CityDto cityDto = new CityDto();
        cityDto.setId(Integer.parseInt(request.getParameter(CITY_ID)));
        return new StudentDto(firstName, lastName, cityDto);
    }
}