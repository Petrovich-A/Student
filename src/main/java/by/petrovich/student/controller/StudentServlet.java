package by.petrovich.student.controller;

import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.dao.impl.StudentDaoImpl;
import by.petrovich.student.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    public void init() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do get");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = "str from servlet";
        request.setAttribute("str", str);
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.receiveAll();
        System.out.println(students);
        request.setAttribute("students", students);
//        ArrayList<Student> students = new ArrayList<>();
//        Student student1 = new Student(1, "first name1", "last name1");
//        Student student2 = new Student(2, "first name2", "last name2");
//        students.add(student1);
//        students.add(student2);
        request.setAttribute("students", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

}
