package by.petrovich.student.dao.impl;

import by.petrovich.student.dao.CityDao;
import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.model.City;
import by.petrovich.student.model.Student;
import by.petrovich.student.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.petrovich.student.dao.FieldName.CITY_ID;
import static by.petrovich.student.dao.FieldName.CITY_NAME;
import static by.petrovich.student.dao.FieldName.STUDENT_FIRST_NAME;
import static by.petrovich.student.dao.FieldName.STUDENT_ID;
import static by.petrovich.student.dao.FieldName.STUDENT_LAST_NAME;

public class StudentDaoImpl implements StudentDao {
    private final String SELECT_ALL = "SELECT student_id, first_name, last_name, city_id, name ";
    private final String JOIN_CITY = "JOIN cities USING (city_id) ";
    private final String DELETE = "DELETE ";
    private final String INSERT = "INSERT INTO students (first_name, last_name, city_id) VALUES (?, ?, ?)";
    private final String FROM = "FROM students ";
    private final String UPDATE = "UPDATE students SET first_name = ?, last_name = ?,  city_id = ? ";
    private final String WHERE_ID = "WHERE student_id = ?";
    private final DatabaseConnector databaseConnector = new DatabaseConnector();
    private final CityDao cityDao = new CityDaoImpl();

    @Override
    public List<Student> receiveAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + FROM + JOIN_CITY);
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
    public Student readById(int id) {
        Student student = null;
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + FROM + JOIN_CITY + WHERE_ID)) {
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
    public void create(Student student) {
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getCity().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(Student student) {
        try (Connection connection = databaseConnector.receiveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE + WHERE_ID)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getCity().getId());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Student buildStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt(STUDENT_ID));
        student.setFirstName(resultSet.getString(STUDENT_FIRST_NAME));
        student.setLastName(resultSet.getString(STUDENT_LAST_NAME));
        student.setCity(buildCity(resultSet));
        return student;
    }

    private City buildCity(ResultSet resultSet) throws SQLException {
        City city = new City();
        city.setId(resultSet.getInt(CITY_ID));
        city.setName(resultSet.getString(CITY_NAME));
        return city;
    }
}
