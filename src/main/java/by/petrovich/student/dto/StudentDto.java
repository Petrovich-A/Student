package by.petrovich.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class StudentDto {
    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private CityDto cityDto;
}