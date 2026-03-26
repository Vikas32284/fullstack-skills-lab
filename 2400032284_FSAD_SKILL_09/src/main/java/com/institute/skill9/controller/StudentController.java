package com.institute.skill9.controller;

import com.institute.skill9.model.Student;
import com.institute.skill9.exception.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        if (id <= 0) {
            throw new InvalidInputException("Invalid ID. ID must be positive.");
        }

        if (id != 1) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }

        return new Student(1, "Vikas Reddy");
    }
}