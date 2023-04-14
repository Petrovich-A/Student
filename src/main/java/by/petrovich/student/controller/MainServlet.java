package by.petrovich.student.controller;

import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.dao.impl.StudentDaoImpl;
import by.petrovich.student.dto.StudentWithCity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
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
        List<StudentWithCity> studentWithCity = STUDENT_DAO.receiveAllWithCites();
        request.setAttribute("studentWithCity", studentWithCity);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
