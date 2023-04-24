package by.petrovich.student.service;

import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> receiveAll();

    Student readById(int id);

    void deleteById(int id);

    void create(StudentDto studentDto);
    void updateById(StudentDto studentDto);

}
