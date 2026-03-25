package com.institute.skill7;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CourseService {

    List<Course> courses = new ArrayList<>();

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourse(int id) {
        try {
            for (Course c : courses) {
                if (c.getCourseId() == id) {
                    return c;
                }
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }

    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course updateCourse(int id, Course course) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                c.setTitle(course.getTitle());
                c.setDuration(course.getDuration());
                c.setFee(course.getFee());
                return c;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        return courses.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }
        return result;
    }
}