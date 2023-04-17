package by.petrovich.student.dao;

import by.petrovich.student.dto.StudentWithCity;
import by.petrovich.student.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> receiveAll();

    List<StudentWithCity> receiveAllWithCites();

    Student readById(int id);

    void deleteById(int id);

}
