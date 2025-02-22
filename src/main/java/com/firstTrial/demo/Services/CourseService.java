package com.firstTrial.demo.Services;

import com.firstTrial.demo.Entities.Course;
import com.firstTrial.demo.Repositories.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        log.info("Fetching all courses");
        List<Course> courses = courseRepository.findAll();
        log.info("Found {} courses", courses.size());
        return courses;
    }

    public Course addCourse(Course course) {
        log.info("Adding course: {}", course);
        try {
            if (course.getId() != null && courseRepository.existsById(course.getId())) {
                log.warn("Course already exists with id: {}", course.getId());
                throw new Exception("Course already exists");
            }
            Course savedCourse = courseRepository.save(course);
            log.info("Course added successfully: {}", savedCourse);
            return savedCourse;
        } catch (Exception ex) {
            log.error("Error while adding course: {}. Exception: {}", course, ex.getMessage(), ex);
            return null;
        }
    }

    public Course updateCourse(Course course) {
        log.info("Updating course: {}", course);
        try {
            if (course.getId() == null || !courseRepository.existsById(course.getId())) {
                log.warn("Course not found with id: {}", course.getId());
                throw new Exception("Course not found");
            }
            Course updatedCourse = courseRepository.save(course);
            log.info("Course updated successfully: {}", updatedCourse);
            return updatedCourse;
        } catch (Exception ex) {
            log.error("Error while updating course: {}. Exception: {}", course, ex.getMessage(), ex);
            return null;
        }
    }

    public void deleteCourse(UUID id) {
        log.info("Deleting course with id: {}", id);
        try {
            if (!courseRepository.existsById(id)) {
                log.warn("Course not found with id: {}", id);
                throw new Exception("Course not found");
            }
            courseRepository.deleteById(id);
            log.info("Course deleted successfully with id: {}", id);
        } catch (Exception ex) {
            log.error("Error while deleting course with id: {}. Exception: {}", id, ex.getMessage(), ex);
        }
    }
}
