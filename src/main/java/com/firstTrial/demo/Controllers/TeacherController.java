package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.Entities.Teacher;
import com.firstTrial.demo.Services.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("")
    public List<Teacher> getAllTeachers(){
        log.info("Fetching all teachers");
        return teacherService.getTeachers();
    }

    @PostMapping("")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        log.info("Adding teacher: {}", teacher);
        return teacherService.addTeacher(teacher);
    }
}
