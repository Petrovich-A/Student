package by.petrovich.student.dao.impl;

import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.model.City;
import by.petrovich.student.model.Student;
import by.petrovich.student.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.petrovich.student.dao.FieldName.CITY_ID;
import static by.petrovich.student.dao.FieldName.FIRST_NAME;
import static by.petrovich.student.dao.FieldName.LAST_NAME;
import static by.petrovich.student.dao.FieldName.NAME;
import static by.petrovich.student.dao.FieldName.STUDENT_ID;

public class StudentDaoImpl implements StudentDao {
    private final String SELECT_ALL = "SELECT student_id, first_name, last_name ";
    private final String FROM = "FROM students";
    private final String JOIN_CITES = "JOIN cites USING (city_id) ";
    private final DatabaseConnector databaseConnector = new DatabaseConnector();

    @Override
    public List<Student> receiveAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + FROM);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            students.add(buildStudent(resultSet));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Map<City, List<Student>> receiveAllWithCites() {
        Map<City, List<Student>> cityListStudent = new HashMap<>();
        List<Student> students = new ArrayList<>();
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + JOIN_CITES + FROM);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                students.add(buildStudent(resultSet));
                City city = new City();
                city.setId(resultSet.getInt(CITY_ID));
                city.setName(resultSet.getString(NAME));
                cityListStudent.put(city, students);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cityListStudent;
    }

    private Student buildStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        while (resultSet.next()) {
            student.setId(resultSet.getInt(STUDENT_ID));
            student.setFirstName(resultSet.getString(FIRST_NAME));
            student.setLastName(resultSet.getString(LAST_NAME));
        }
        return student;
    }
}
