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
import java.util.List;

import static by.petrovich.student.controller.RequestAttributeNames.STUDENTS;


@WebServlet("/go-to-student-page")
public class GoToStudentPageServlet extends HttpServlet {
    private final StudentDao STUDENT_DAO = new StudentDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = STUDENT_DAO.receiveAll();
        request.setAttribute(STUDENTS, students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/student.jsp");
        requestDispatcher.forward(request, response);
    }

}