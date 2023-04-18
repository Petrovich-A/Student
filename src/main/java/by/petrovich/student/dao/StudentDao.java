package by.petrovich.student.dao;

import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.dto.StudentWithCityDto;
import by.petrovich.student.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> receiveAll();

    List<StudentWithCityDto> receiveAllWithCites();

    Student readById(int id);

    void deleteById(int id);

    void create(StudentDto studentDto);

}
