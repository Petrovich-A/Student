package by.petrovich.student.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class StudentDto {
    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private CityDto cityDto;

    public StudentDto() {
    }

    public StudentDto(String studentFirstName, String studentLastName, CityDto cityDto) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.cityDto = cityDto;
    }

    public StudentDto(int studentId, String studentFirstName, String studentLastName, CityDto cityDto) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.cityDto = cityDto;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public CityDto getCityDto() {
        return cityDto;
    }

    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return studentId == that.studentId && Objects.equals(studentFirstName, that.studentFirstName) && Objects.equals(studentLastName, that.studentLastName) && Objects.equals(cityDto, that.cityDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentFirstName, studentLastName, cityDto);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StudentDto.class.getSimpleName() + "[", "]")
                .add("studentId=" + studentId)
                .add("studentFirstName='" + studentFirstName + "'")
                .add("studentLastName='" + studentLastName + "'")
                .add("cityDto=" + cityDto)
                .toString();
    }
}
