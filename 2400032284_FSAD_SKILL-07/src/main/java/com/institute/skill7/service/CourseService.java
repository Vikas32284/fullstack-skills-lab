package com.institute.skill7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.institute.skill7.entity.Course;
import com.institute.skill7.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public Course addCourse(Course course) {
        return repo.save(course);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return repo.findById(id);
    }

    public Course updateCourse(Course course) {
        return repo.save(course);
    }

    public void deleteCourse(int id) {
        repo.deleteById(id);
    }

    public List<Course> searchByTitle(String title) {
        return repo.findByTitleContaining(title);
    }
}