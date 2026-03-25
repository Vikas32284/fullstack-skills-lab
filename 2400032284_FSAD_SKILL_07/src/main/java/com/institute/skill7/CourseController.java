package com.institute.skill7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return service.addCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        return service.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        service.deleteCourse(id);
        return "Deleted successfully";
    }

    @GetMapping("/search/title/{title}")
    public List<Course> search(@PathVariable String title) {
        return service.searchByTitle(title);
    }
}