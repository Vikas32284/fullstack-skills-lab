package com.institute.Skill_4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    public Student student() {
        Student s = new Student(102, "Vikas", "Spring", 3);
        s.setCourse("Spring Boot");
        s.setYear(3);
        return s;
    }
}