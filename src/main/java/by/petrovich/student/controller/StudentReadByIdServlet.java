package by.petrovich.student.controller;

import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.dao.impl.StudentDaoImpl;
import by.petrovich.student.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.petrovich.student.controller.RequestAttributeNames.STUDENT;
import static by.petrovich.student.controller.RequestAttributeNames.STUDENT_ID;


@WebServlet("/studentReadById")
public class StudentReadByIdServlet extends HttpServlet {
    private final StudentDao STUDENT_DAO = new StudentDaoImpl();

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
        Student student = STUDENT_DAO.readById(studentId);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/studentRead.jsp");
        request.setAttribute(STUDENT, student);
        requestDispatcher.forward(request, response);
    }
}