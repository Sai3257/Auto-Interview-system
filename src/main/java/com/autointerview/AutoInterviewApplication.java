package com.autointerview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutoInterviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoInterviewApplication.class, args);
    }
} 