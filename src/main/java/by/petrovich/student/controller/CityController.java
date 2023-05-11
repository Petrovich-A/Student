package by.petrovich.student.controller;

import by.petrovich.student.dto.CityDto;
import by.petrovich.student.model.City;
import by.petrovich.student.service.CityService;
import by.petrovich.student.service.impl.CityServiceImpl;
import lombok.extern.java.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.petrovich.student.utils.Constants.ActionNames.CREATE;
import static by.petrovich.student.utils.Constants.ActionNames.DELETE;
import static by.petrovich.student.utils.Constants.ActionNames.FORWARD_TO_CREATE_PAGE;
import static by.petrovich.student.utils.Constants.ActionNames.FORWARD_TO_UPDATE_PAGE;
import static by.petrovich.student.utils.Constants.ActionNames.READ;
import static by.petrovich.student.utils.Constants.ActionNames.UPDATE;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.ACTION;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITY;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITY_ID;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITY_NAME;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.UPDATED_CITY_NAME;

@WebServlet("/city")
@Log
public class CityController extends HttpServlet {
    private final CityService CITY_SERVICE = new CityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        selectAction(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        selectAction(req, resp);
    }

    private void selectAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (receiveAction(request)) {
            case READ:
                read(request, response);
                break;
            case DELETE:
                delete(request, response);
                break;
            case CREATE:
                create(request, response);
                break;
            case UPDATE:
                update(request, response);
                break;
            case FORWARD_TO_UPDATE_PAGE:
                forwardToUpdatePage(request, response);
                break;
            case FORWARD_TO_CREATE_PAGE:
                forwardToCreatePage(request, response);
                break;
            default:
        }
    }

    private void forwardToCreatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/cityCreate.jsp");
        requestDispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CityDto cityDto = buildCityDto(request);
        CITY_SERVICE.updateById(cityDto);
        response.sendRedirect(request.getContextPath() + "/redirect-to-city-page");
    }

    private void forwardToUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(CITY_ID));
        City city = CITY_SERVICE.readById(id);
        request.setAttribute(CITY_ID, id);
        request.setAttribute(CITY_NAME, city.getName());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/cityUpdate.jsp");
        requestDispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter(CITY_NAME);
        CityDto cityDto = new CityDto();
        cityDto.setName(name);
        CITY_SERVICE.create(cityDto);
        response.sendRedirect(request.getContextPath() + "/redirect-to-city-page");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(CITY_ID));
        CITY_SERVICE.deleteById(id);
        response.sendRedirect(request.getContextPath() + "/redirect-to-city-page");
    }

    private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(CITY_ID));
        City city = CITY_SERVICE.readById(id);
        request.setAttribute(CITY, city);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/cityRead.jsp");
        requestDispatcher.forward(request, response);
    }

    private String receiveAction(HttpServletRequest request) {
        String action = request.getParameter(ACTION);
        if (action.equals(null)) {
            log.severe("StudentId is null");
        }
        return action;
    }

    private CityDto buildCityDto(HttpServletRequest request) {
        return CityDto.builder()
                .id(Integer.parseInt(request.getParameter(CITY_ID)))
                .name(request.getParameter(UPDATED_CITY_NAME))
                .build();
    }

}