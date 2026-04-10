package com.institute.skill7.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.institute.skill7.entity.Course;
import com.institute.skill7.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // CREATE
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return ResponseEntity.status(201).body(service.addCourse(course));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        Optional<Course> course = service.getCourseById(id);

        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        } else {
            return ResponseEntity.status(404).body("Course not found");
        }
    }

    // UPDATE
    @PutMapping
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        Optional<Course> existing = service.getCourseById(course.getCourseId());

        if (existing.isPresent()) {
            return ResponseEntity.ok(service.updateCourse(course));
        } else {
            return ResponseEntity.status(404).body("Course not found");
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        Optional<Course> existing = service.getCourseById(id);

        if (existing.isPresent()) {
            service.deleteCourse(id);
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Course not found");
        }
    }

    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}