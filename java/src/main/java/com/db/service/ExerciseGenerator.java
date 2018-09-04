package com.db.service;

import com.db.model.Exercise;

import java.util.List;

public interface ExerciseGenerator {
    List<Exercise> generate(int amount);
}
