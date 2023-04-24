package by.petrovich.student.dao;

import by.petrovich.student.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> receiveAll();

    Student readById(int id);

    void deleteById(int id);

    void create(Student student);
    void updateById(Student student);

}
