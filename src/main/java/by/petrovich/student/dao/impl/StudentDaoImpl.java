package by.petrovich.student.dao.impl;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.dto.StudentWithCityDto;
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
    private final String DELETE = "DELETE ";
    private final String INSERT = "INSERT INTO students (first_name, last_name, city_id) VALUES (?, ?, ?)";
    private final String SELECT_ALL_WITH_CITY = "SELECT student_id, first_name, last_name, city_id, name ";
    private final String FROM = "FROM students ";
    private final String WHERE_ID = "WHERE student_id = ?";
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
    public List<StudentWithCityDto> receiveAllWithCites() {
        List<StudentWithCityDto> studentsWithCities = new ArrayList<>();
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

    @Override
    public Student readById(int id) {
        Student student = new Student();
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + FROM + WHERE_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = buildStudent(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public void deleteById(int id) {
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE + FROM + WHERE_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(StudentDto studentDto) {
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, studentDto.getFirstName());
            preparedStatement.setString(2, studentDto.getLastName());
            preparedStatement.setInt(3, studentDto.getCityId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Student buildStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt(STUDENT_ID));
        student.setFirstName(resultSet.getString(FIRST_NAME));
        student.setLastName(resultSet.getString(LAST_NAME));
        return student;
    }

    private StudentWithCityDto buildStudentWithCity(ResultSet resultSet) throws SQLException {
        StudentWithCityDto studentWithCityDto = new StudentWithCityDto();
        studentWithCityDto.setStudentId(resultSet.getInt(STUDENT_ID));
        studentWithCityDto.setStudentFirstName(resultSet.getString(FIRST_NAME));
        studentWithCityDto.setStudentLastName(resultSet.getString(LAST_NAME));
        studentWithCityDto.setCityId(resultSet.getInt(CITY_ID));
        studentWithCityDto.setCityName(resultSet.getString(NAME));
        return studentWithCityDto;
    }
}
