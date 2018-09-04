package com.db.controller;

import com.db.model.Exercise;
import com.db.service.ExerciseGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JavaExamController {
    private final ExerciseGenerator exerciseGenerator;

    @GetMapping("/java")
    public List<Exercise> getExercises(@RequestParam("amount") int amount){
        return exerciseGenerator.generate(amount);
    }
}
