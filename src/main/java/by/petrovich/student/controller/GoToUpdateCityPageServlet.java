package by.petrovich.student.controller;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dao.impl.CityDaoImpl;
import by.petrovich.student.model.City;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.petrovich.student.controller.RequestAttributeNames.CITY_ID;
import static by.petrovich.student.controller.RequestAttributeNames.CITY_NAME;


@WebServlet("/goToUpdateCityPage")
public class GoToUpdateCityPageServlet extends HttpServlet {
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
        Integer id = Integer.valueOf(request.getParameter(CITY_ID));
        City city = CITY_DAO.readById(id);
        request.setAttribute(CITY_ID, id);
        request.setAttribute(CITY_NAME, city.getName());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/cityUpdate.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
