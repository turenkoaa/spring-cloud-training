package com.db.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MathClass {
    public static void main(String[] args) {
        SpringApplication.run(MathClass.class, args);
    }
}
