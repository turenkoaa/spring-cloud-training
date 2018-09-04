package com.db.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    private String name;
    @Singular
    private List<Section> sections;
}
