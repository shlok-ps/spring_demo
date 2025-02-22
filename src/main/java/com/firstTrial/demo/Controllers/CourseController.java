package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.Entities.Course;
import com.firstTrial.demo.Services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public List<Course> getAllCourses(){
        log.info("Fetching all courses");
        return courseService.getAllCourses();
    }

    @PostMapping("")
    public Course addCourse(@RequestBody Course course){
        log.info("Adding course: {}", course);
        return courseService.addCourse(course);
    }
}
