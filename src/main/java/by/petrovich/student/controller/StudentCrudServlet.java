package by.petrovich.student.controller;

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


@WebServlet("/studentCrudServlet")
public class StudentCrudServlet extends HttpServlet {
    private final static Logger LOGGER = LogManager.getLogger();

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
        RequestDispatcher dispatcher;
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            selectAction(request, response, action);
        } else {
            LOGGER.log(Level.ERROR, "StudentId is null");
        }
    }

    private void selectAction(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        if ("readById".equals(action)) {
            dispatcher = getServletContext().getRequestDispatcher("/studentReadById");
            dispatcher.forward(request, response);
        }
        if ("create".equals(action)) {
            dispatcher = getServletContext().getRequestDispatcher("/studentCreate");
            dispatcher.forward(request, response);
        }
        if ("deleteById".equals(action)) {
            dispatcher = getServletContext().getRequestDispatcher("/studentDeleteById");
            dispatcher.forward(request, response);
        }
        if ("goToCreatePage".equals(action)) {
            dispatcher = getServletContext().getRequestDispatcher("/goToCreateStudentPage");
            dispatcher.forward(request, response);
        }
        if ("update".equals(action)) {
            dispatcher = getServletContext().getRequestDispatcher("/studentUpdateById");
            dispatcher.forward(request, response);
        }
    }

    public void destroy() {
    }

}