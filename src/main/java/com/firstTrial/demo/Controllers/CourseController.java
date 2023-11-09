package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.Entities.Course;
import com.firstTrial.demo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;
    @GetMapping("")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
    @PostMapping("")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

}
