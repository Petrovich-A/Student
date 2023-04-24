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

import static by.petrovich.student.controller.RequestAttributeNames.CITY_ID;
import static by.petrovich.student.controller.RequestAttributeNames.UPDATED_CITY_NAME;


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
        CityDto cityDto = buildCityDto(request);
        CITY_DAO.updateById(cityDto);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/goToCityPage");
        requestDispatcher.forward(request, response);
    }

    private CityDto buildCityDto(HttpServletRequest request) {
        CityDto cityDto = new CityDto();
        cityDto.setName(request.getParameter(UPDATED_CITY_NAME));
        cityDto.setId(Integer.parseInt(request.getParameter(CITY_ID)));
        return cityDto;
    }

    public void destroy() {
    }

}
