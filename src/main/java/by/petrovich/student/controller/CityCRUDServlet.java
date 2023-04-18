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


@WebServlet("/cityCRUDServlet")
public class CityCRUDServlet extends HttpServlet {
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
        int id = Integer.parseInt(request.getParameter("cityId"));
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (request.getParameter("cityId") != null) {
            if ("create".equals(action)) {
                requestDispatcher = request.getRequestDispatcher("/cityCreate");
                requestDispatcher.forward(request, response);
            }
            if ("readById".equals(action)) {
                requestDispatcher = request.getRequestDispatcher("/cityReadById");
                requestDispatcher.forward(request, response);
            }
            if ("goToCreatePage".equals(action)) {
                requestDispatcher = request.getRequestDispatcher("/goToCreateCityPage");
                requestDispatcher.forward(request, response);
            }
            if ("update".equals(action)) {
                requestDispatcher = request.getRequestDispatcher("/cityUpdateById");
                requestDispatcher.forward(request, response);
            }
            if ("deleteById".equals(action)) {
                requestDispatcher = request.getRequestDispatcher("/cityDeleteById");
                requestDispatcher.forward(request, response);
            }
        } else {
            LOGGER.log(Level.ERROR, "cityId: \"{}\" is null", id);
        }
    }

    public void destroy() {
    }

}
