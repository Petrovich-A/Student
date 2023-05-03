package by.petrovich.student.controller;

import by.petrovich.student.dto.CityDto;
import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.model.City;
import by.petrovich.student.model.Student;
import by.petrovich.student.service.CityService;
import by.petrovich.student.service.StudentService;
import by.petrovich.student.service.impl.CityServiceImpl;
import by.petrovich.student.service.impl.StudentServiceImpl;
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
import java.util.List;

import static by.petrovich.student.utils.Constants.RequestAttributeNames.ACTION;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITIES;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.CITY_ID;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.STUDENT;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.STUDENT_FIRST_NAME;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.STUDENT_ID;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.STUDENT_LAST_NAME;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.UPDATED_STUDENT_FIRST_NAME;
import static by.petrovich.student.utils.Constants.RequestAttributeNames.UPDATED_STUDENT_LAST_NAME;

@WebServlet("/student-controller")
public class StudentController extends HttpServlet {
    private final StudentService STUDENT_SERVICE = new StudentServiceImpl();
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/studentCreate.jsp");
        List<City> cities = CITY_SERVICE.receiveAll();
        request.setAttribute(CITIES, cities);
        requestDispatcher.forward(request, response);
    }

    private void goToUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/go-to-student-page");
        dispatcher.forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        STUDENT_SERVICE.create(buildStudentDtoForCreate(request));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/go-to-student-page");
        dispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(STUDENT_ID));
        STUDENT_SERVICE.deleteById(id);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/go-to-student-page");
        dispatcher.forward(request, response);
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
            LOGGER.log(Level.ERROR, "StudentId is null");
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
}