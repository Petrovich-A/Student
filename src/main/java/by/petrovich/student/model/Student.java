package by.petrovich.student.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private City city;
}