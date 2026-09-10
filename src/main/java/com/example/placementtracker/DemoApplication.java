package com.example.placementtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // Spring Boot will now automatically pick up the database settings from application.properties
        SpringApplication.run(DemoApplication.class, args);
    }
}
