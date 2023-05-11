package by.petrovich.student.controller;

import by.petrovich.student.dto.CityDto;
import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.model.City;
import by.petrovich.student.model.Student;
import by.petrovich.student.service.CityService;
import by.petrovich.student.service.StudentService;
import by.petrovich.student.service.impl.CityServiceImpl;
import by.petrovich.student.service.impl.StudentServiceImpl;
import lombok.extern.java.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.petrovich.student.utils.Constants.ActionNames.CREATE;
import static by.petrovich.student.utils.Constants.ActionNames.DELETE;
import static by.petrovich.student.utils.Constants.ActionNames.FORWARD_TO_CREATE_PAGE;
import static by.petrovich.student.utils.Constants.ActionNames.FORWARD_TO_UPDATE_PAGE;
import static by.petrovich.student.utils.Constants.ActionNames.READ;
import static by.petrovich.student.utils.Constants.ActionNames.UPDATE;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.ACTION;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITIES;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITY_ID;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.STUDENT;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.STUDENT_FIRST_NAME;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.STUDENT_ID;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.STUDENT_LAST_NAME;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.UPDATED_STUDENT_FIRST_NAME;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.UPDATED_STUDENT_LAST_NAME;

@WebServlet("/student")
@Log
public class StudentController extends HttpServlet {
    private final StudentService STUDENT_SERVICE = new StudentServiceImpl();
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/studentCreate.jsp");
        List<City> cities = CITY_SERVICE.receiveAll();
        request.setAttribute(CITIES, cities);
        requestDispatcher.forward(request, response);
    }

    private void forwardToUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter(STUDENT_ID));
        Student student = STUDENT_SERVICE.readById(studentId);
        List<City> cities = CITY_SERVICE.receiveAll();
        request.setAttribute(STUDENT, student);
        request.setAttribute(CITIES, cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/studentUpdate.jsp");
        requestDispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        STUDENT_SERVICE.updateById(buildStudentDtoForUpdate(request));
        response.sendRedirect(request.getContextPath() + "/redirect-to-student-page");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        STUDENT_SERVICE.create(buildStudentDtoForCreate(request));
        response.sendRedirect(request.getContextPath() + "/redirect-to-student-page");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(STUDENT_ID));
        STUDENT_SERVICE.deleteById(id);
        response.sendRedirect(request.getContextPath() + "/redirect-to-student-page");
    }

    private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter(STUDENT_ID));
        Student student = STUDENT_SERVICE.readById(studentId);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/studentRead.jsp");
        request.setAttribute(STUDENT, student);
        requestDispatcher.forward(request, response);
    }

    private String receiveAction(HttpServletRequest request) {
        String action = request.getParameter(ACTION);
        if (action.equals(null)) {
            log.severe("StudentId is null");
        }
        return action;
    }

    private StudentDto buildStudentDtoForCreate(HttpServletRequest request) {
        return StudentDto.builder()
                .studentFirstName(request.getParameter(STUDENT_FIRST_NAME))
                .studentLastName(request.getParameter(STUDENT_LAST_NAME))
                .cityDto(buildCityDto(request))
                .build();
    }

    private StudentDto buildStudentDtoForUpdate(HttpServletRequest request) {
        return StudentDto.builder()
                .studentId(Integer.parseInt(request.getParameter(STUDENT_ID)))
                .studentFirstName(request.getParameter(UPDATED_STUDENT_FIRST_NAME))
                .studentLastName(request.getParameter(UPDATED_STUDENT_LAST_NAME))
                .cityDto(buildCityDto(request))
                .build();
    }

    private CityDto buildCityDto(HttpServletRequest request) {
        return CityDto.builder()
                .id(Integer.parseInt(request.getParameter(CITY_ID)))
                .build();
    }

    @Override
    public void log(String msg) {
        super.log(msg);
    }
}