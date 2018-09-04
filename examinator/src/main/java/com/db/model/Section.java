package com.db.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    private String name;
    @Singular
    private List<Exercise> exercises;
}
