package by.petrovich.student.controller;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dao.impl.CityDaoImpl;
import by.petrovich.student.model.City;
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


@WebServlet("/cityReadById")
public class CityReadByIdServlet extends HttpServlet {
    private final static Logger LOGGER = LogManager.getLogger();
    private static final CityDao CITY_DAO = new CityDaoImpl();

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
        int id = 0;
        if (request.getParameter("cityId") != null) {
            id = Integer.parseInt(request.getParameter("cityId"));
            City city = CITY_DAO.readById(id);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/cityRead.jsp");
            request.setAttribute("city", city);
            requestDispatcher.forward(request, response);
        } else {
            LOGGER.log(Level.ERROR, "cityId: \"{}\" is null", id);
        }
    }

    public void destroy() {
    }

}
