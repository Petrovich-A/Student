package by.petrovich.student.dto;

import java.util.Objects;

public class StudentWithCityDto {
    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private int cityId;
    private String cityName;


    public StudentWithCityDto() {
    }

    public StudentWithCityDto(int studentId, String studentFirstName, String studentLastName, int cityId, String cityName) {
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
        StudentWithCityDto that = (StudentWithCityDto) o;
        return studentId == that.studentId && cityId == that.cityId && Objects.equals(studentFirstName, that.studentFirstName) && Objects.equals(studentLastName, that.studentLastName) && Objects.equals(cityName, that.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentFirstName, studentLastName, cityId, cityName);
    }

    @Override
    public String toString() {
        return "StudentWithCity{" +
                "studentId=" + studentId +
                ", firstName='" + studentFirstName + '\'' +
                ", lastName='" + studentLastName + '\'' +
                ", cityId=" + cityId +
                ", name='" + cityName + '\'' +
                '}';
    }
}
