package by.petrovich.student.model;

import com.sun.istack.internal.NotNull;
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
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private City city;
}