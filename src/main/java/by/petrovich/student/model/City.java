package by.petrovich.student.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class City {
    private int id;
    @NonNull
    private String name;
}