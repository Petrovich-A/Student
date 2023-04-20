package by.petrovich.student.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/goToUpdateCityPage")
public class GoToUpdateCityPageServlet extends HttpServlet {
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
        Integer id = Integer.valueOf(request.getParameter("cityId"));
        String name = request.getParameter("cityName");
        request.setAttribute("cityId", id);
        request.setAttribute("cityName", name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/pages/cityUpdate.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
