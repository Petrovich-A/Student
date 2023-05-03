package by.petrovich.student.controller;

import by.petrovich.student.dto.CityDto;
import by.petrovich.student.model.City;
import by.petrovich.student.service.CityService;
import by.petrovich.student.service.impl.CityServiceImpl;
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

import static by.petrovich.student.utils.Constants.RequestAttributeNames.ACTION;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITY;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITY_ID;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITY_NAME;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.UPDATED_CITY_NAME;

@WebServlet("/city-controller")
public class CityController extends HttpServlet {
    private final CityService CITY_SERVICE = new CityServiceImpl();
    private final static Logger LOGGER = LogManager.getLogger();

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
            case "read":
                read(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "go-to-update-page":
                goToUpdatePage(request, response);
                break;
            case "go-to-create-page":
                goToCreatePage(request, response);
                break;
            default:
        }
    }

    private void goToCreatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/cityCreate.jsp");
        requestDispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CityDto cityDto = buildCityDto(request);
        CITY_SERVICE.updateById(cityDto);
        response.sendRedirect(request.getContextPath() + "/go-to-city-page");
    }

    private void goToUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        response.sendRedirect(request.getContextPath() + "/go-to-city-page");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(CITY_ID));
        CITY_SERVICE.deleteById(id);
        response.sendRedirect(request.getContextPath() + "/go-to-city-page");
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
            LOGGER.log(Level.ERROR, "StudentId is null");
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