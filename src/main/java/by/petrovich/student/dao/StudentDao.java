package by.petrovich.student.dao;

import by.petrovich.student.model.City;
import by.petrovich.student.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Student> receiveAll();
    Map<City, List<Student>> receiveAllWithCites();
}
