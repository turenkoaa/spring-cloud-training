package com.db.controller;

import com.db.model.Exam;
import com.db.model.Exercise;
import com.db.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ExamController {
    @Autowired
    private RestTemplate restTemplate;

    @PutMapping("/exam")
    public Exam getExam(@RequestBody Map<String, Integer> examRequest) {
        List<Section> sections = examRequest
                .entrySet()
                .stream()
                .map(e -> {
                    String microServiceName = e.getKey();
                    //по имени микросервиса определяет урл до первого слеша, т к рест темплейт помечен как лоад балансер
                    String url = "http://" + microServiceName + "/" + microServiceName + "?amount=" + e.getValue();
                    Exercise[] exercises = restTemplate.getForObject(url, Exercise[].class);
                    return Section.builder()
                            .exercises(Arrays.asList(exercises))
                            .name(microServiceName)
                            .build();
                })
                .collect(Collectors.toList());
        return Exam.builder()
                .sections(sections)
                .name("super exam")
                .build();
    }
}
