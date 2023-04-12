package by.petrovich.student.dao.impl;

import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.model.Student;
import by.petrovich.student.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final String SQL_SELECT_ALL = "SELECT student_id, first_name, last_name FROM students;";
    private final DatabaseConnector databaseConnector = new DatabaseConnector();

    @Override
    public List<Student> receiveAll() {
        List<Student> allStudents = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = databaseConnector.receiveConnection();
            preparedStatement = connection.prepareStatement("SELECT student_id, first_name, last_name FROM students;");
            if (resultSet.isClosed()) {
                System.err.println("resultSet.isClosed()");
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("student_id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                allStudents.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                resultSet.close();
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return allStudents;
    }
}
