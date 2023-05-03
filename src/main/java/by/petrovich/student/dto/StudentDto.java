package by.petrovich.student.dto;

import com.sun.istack.internal.NotNull;
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
    @NotNull
    private String studentFirstName;
    @NotNull
    private String studentLastName;
    @NotNull
    private CityDto cityDto;
}