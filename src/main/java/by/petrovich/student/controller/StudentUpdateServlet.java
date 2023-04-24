package by.petrovich.student.controller;

import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.dao.impl.StudentDaoImpl;
import by.petrovich.student.dto.StudentDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.petrovich.student.controller.RequestAttributeNames.CITY_ID;
import static by.petrovich.student.controller.RequestAttributeNames.STUDENT_ID;
import static by.petrovich.student.controller.RequestAttributeNames.UPDATED_STUDENT_FIRST_NAME;
import static by.petrovich.student.controller.RequestAttributeNames.UPDATED_STUDENT_LAST_NAME;


@WebServlet("/studentUpdateById")
public class StudentUpdateServlet extends HttpServlet {
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
        STUDENT_DAO.updateById(buildStudentDto(request));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/goToStudentPage");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }

    private StudentDto buildStudentDto(HttpServletRequest request) {
        int studentId = Integer.parseInt(request.getParameter(STUDENT_ID));
        String firstName = request.getParameter(UPDATED_STUDENT_FIRST_NAME);
        String lastName = request.getParameter(UPDATED_STUDENT_LAST_NAME);
        int cityId = Integer.parseInt(request.getParameter(CITY_ID));
        return new StudentDto(studentId, firstName, lastName, cityId);
    }
}