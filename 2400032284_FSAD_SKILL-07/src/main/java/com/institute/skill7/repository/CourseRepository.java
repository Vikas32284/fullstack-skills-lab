package com.institute.skill7.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.institute.skill7.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByTitleContaining(String title);
}