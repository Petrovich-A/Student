package by.petrovich.student.service.impl;

import by.petrovich.student.dao.StudentDao;
import by.petrovich.student.dao.impl.StudentDaoImpl;
import by.petrovich.student.dto.StudentDto;
import by.petrovich.student.model.City;
import by.petrovich.student.model.Student;
import by.petrovich.student.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private static final StudentDao STUDENT_DAO = new StudentDaoImpl();

    @Override
    public List<Student> receiveAll() {
        return STUDENT_DAO.receiveAll();
    }

    @Override
    public Student readById(int id) {
        return STUDENT_DAO.readById(id);
    }

    @Override
    public void deleteById(int id) {
        STUDENT_DAO.deleteById(id);
    }

    @Override
    public void create(StudentDto studentDto) {
        STUDENT_DAO.create(buildStudent(studentDto));
    }

    @Override
    public void updateById(StudentDto studentDto) {
        STUDENT_DAO.updateById(buildStudent(studentDto));
    }

    private Student buildStudent(StudentDto studentDto) {
        City city = new City();
        city.setId(studentDto.getCityDto().getId());
        Student student = new Student();
        student.setCity(city);
        student.setId(studentDto.getStudentId());
        student.setFirstName(studentDto.getStudentFirstName());
        student.setLastName(studentDto.getStudentLastName());
        return student;
    }
}
