package by.petrovich.student.controller;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dao.impl.CityDaoImpl;
import by.petrovich.student.dto.CityDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cityUpdateById")
public class CityUpdateByIdServlet extends HttpServlet {
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
        CityDto cityDto = new CityDto();
        cityDto.setName(request.getParameter("updatedCityName"));
        cityDto.setId(Integer.parseInt(request.getParameter("cityId")));
        CITY_DAO.updateById(cityDto);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/goToCityPage");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
