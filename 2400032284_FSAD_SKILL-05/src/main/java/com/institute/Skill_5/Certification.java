package com.institute.Skill_5;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 201;
    private String name = "Spring Boot Certification";
    private String dateOfCompletion = "2026";

    public String toString() {
        return id + " " + name + " " + dateOfCompletion;
    }
}