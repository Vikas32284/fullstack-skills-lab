package com.institute.Skill_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApp {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(StudentConfig.class);

        Student s = context.getBean(Student.class);
        s.display();
    }
}