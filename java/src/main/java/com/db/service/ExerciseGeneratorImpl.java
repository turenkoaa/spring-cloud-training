package com.db.service;

import com.db.model.Exercise;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ExerciseGeneratorImpl implements ExerciseGenerator {
    private List<Exercise> exercises = new ArrayList<>();

    @PostConstruct
    public void init(){
        exercises.add(Exercise.builder().question("What is java last version?").answer("10").build());
        exercises.add(Exercise.builder().question("What is maven last version?").answer("3.5.9").build());
        exercises.add(Exercise.builder().question("What is groovy last version?").answer("2+").build());
    }

    @Override
    public List<Exercise> generate(int amount) {
        Collections.shuffle(exercises);
        return exercises.subList(0, amount);
    }
}
