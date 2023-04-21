package by.petrovich.student.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class StudentDto {
    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private int cityId;
    private String cityName;

    public StudentDto() {
    }

    public StudentDto(String studentFirstName, String studentLastName, int cityId) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.cityId = cityId;
    }

    public StudentDto(int studentId, String studentFirstName, String studentLastName, int cityId, String cityName) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.cityId = cityId;
        this.cityName = cityName;
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

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return studentId == that.studentId && cityId == that.cityId && Objects.equals(studentFirstName, that.studentFirstName) && Objects.equals(studentLastName, that.studentLastName) && Objects.equals(cityName, that.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentFirstName, studentLastName, cityId, cityName);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StudentDto.class.getSimpleName() + "[", "]")
                .add("studentId=" + studentId)
                .add("studentFirstName='" + studentFirstName + "'")
                .add("studentLastName='" + studentLastName + "'")
                .add("cityId=" + cityId)
                .add("cityName='" + cityName + "'")
                .toString();
    }
}
