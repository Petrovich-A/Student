package by.petrovich.student.dto;

import java.util.Objects;
import java.util.StringJoiner;

public class StudentDto {
    private String firstName;
    private String lastName;
    private Integer cityId;

    public StudentDto() {
    }

    public StudentDto(String firstName, String lastName, int cityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cityId = cityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return cityId == that.cityId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, cityId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StudentDto.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("cityId=" + cityId)
                .toString();
    }
}
