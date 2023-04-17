package by.petrovich.student.controller;

import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.dao.impl.StudentDaoImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/studentCRUDServlet")
public class StudentCRUDServlet extends HttpServlet {
    private final static Logger LOGGER = LogManager.getLogger();
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
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("studentId"));
        String action = request.getParameter("action");
        RequestDispatcher dispatcher;
        if (request.getParameter("studentId") != null) {
            if ("readByIdServlet".equals(action)) {
                dispatcher = getServletContext().getRequestDispatcher("/studentReadById");
                dispatcher.forward(request, response);
            }
            if ("deleteByIdServlet".equals(action)) {
                dispatcher = getServletContext().getRequestDispatcher("/studentDeleteById");
                dispatcher.forward(request, response);
            }
        } else {
            LOGGER.log(Level.ERROR, "StudentId: \"{}\" is null", id);
        }
    }

    public void destroy() {
    }

}
