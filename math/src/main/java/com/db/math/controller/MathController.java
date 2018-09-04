package com.db.math.controller;

import com.db.math.model.Exercise;
import com.db.math.service.ExerciseGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class MathController {
    private final ExerciseGenerator exerciseGenerator;

    @GetMapping("/math")
    public List<Exercise> getExercises(@RequestParam("amount") int amount){
        return IntStream.range(0, amount)
                .mapToObj(i -> exerciseGenerator.generate())
                .collect(Collectors.toList());
    }
}
