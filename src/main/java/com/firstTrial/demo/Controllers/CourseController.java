package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.Entities.Course;
import com.firstTrial.demo.Services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        log.info("API call: getAllCourses");
        return courseService.getAllCourses();
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        log.info("API call: addCourse - {}", course);
        return courseService.addCourse(course);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        log.info("API call: updateCourse - {}", course);
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable UUID id) {
        log.info("API call: deleteCourse with id: {}", id);
        courseService.deleteCourse(id);
        return "Course deleted with id: " + id;
    }
}
