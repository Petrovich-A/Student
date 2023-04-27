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


@WebServlet("/cityCrudServlet")
public class CityCrudServlet extends HttpServlet {
    private final static Logger LOGGER = LogManager.getLogger();

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
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            selectAction(request, response, action);
        } else {
            LOGGER.log(Level.ERROR, "cityId is null");
        }
    }

    private void selectAction(HttpServletRequest request, HttpServletResponse response, String action) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        if ("create".equals(action)) {
            requestDispatcher = request.getRequestDispatcher("/cityCreate");
            requestDispatcher.forward(request, response);
        }
        if ("readById".equals(action)) {
            requestDispatcher = request.getRequestDispatcher("/cityReadById");
            requestDispatcher.forward(request, response);
        }
        if ("goToUpdateCityPage".equals(action)) {
            requestDispatcher = request.getRequestDispatcher("/goToUpdateCityPage");
            requestDispatcher.forward(request, response);
        }
        if ("deleteById".equals(action)) {
            requestDispatcher = request.getRequestDispatcher("/cityDeleteById");
            requestDispatcher.forward(request, response);
        }
    }
}