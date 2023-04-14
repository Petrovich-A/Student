package by.petrovich.student.dao.impl;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.dto.StudentWithCity;
import by.petrovich.student.model.Student;
import by.petrovich.student.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.petrovich.student.dao.FieldName.CITY_ID;
import static by.petrovich.student.dao.FieldName.FIRST_NAME;
import static by.petrovich.student.dao.FieldName.LAST_NAME;
import static by.petrovich.student.dao.FieldName.NAME;
import static by.petrovich.student.dao.FieldName.STUDENT_ID;

public class StudentDaoImpl implements StudentDao {
    private final String SELECT_ALL = "SELECT student_id, first_name, last_name ";
    private final String SELECT_ALL_WITH_CITY = "SELECT student_id, first_name, last_name, city_id, name ";
    private final String FROM = "FROM students ";
    private final String JOIN_CITIES = "JOIN cities USING (city_id) ";
    private final DatabaseConnector databaseConnector = new DatabaseConnector();
    private final CityDao cityDao = new CityDaoImpl();

    @Override
    public List<Student> receiveAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + FROM);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                students.add(buildStudent(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public List<StudentWithCity> receiveAllWithCites() {
        List<StudentWithCity> studentsWithCities = new ArrayList<>();
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_WITH_CITY + FROM + JOIN_CITIES);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                studentsWithCities.add(buildStudentWithCity(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentsWithCities;
    }

    private Student buildStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt(STUDENT_ID));
        student.setFirstName(resultSet.getString(FIRST_NAME));
        student.setLastName(resultSet.getString(LAST_NAME));
        return student;
    }

    private StudentWithCity buildStudentWithCity(ResultSet resultSet) throws SQLException {
        StudentWithCity studentWithCity = new StudentWithCity();
        studentWithCity.setStudentId(resultSet.getInt(STUDENT_ID));
        studentWithCity.setStudentFirstName(resultSet.getString(FIRST_NAME));
        studentWithCity.setStudentLastName(resultSet.getString(LAST_NAME));
        studentWithCity.setCityId(resultSet.getInt(CITY_ID));
        studentWithCity.setCityName(resultSet.getString(NAME));
        return studentWithCity;
    }
}
