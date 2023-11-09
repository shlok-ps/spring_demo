package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.Entities.Teacher;
import com.firstTrial.demo.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping("")
    public List<Teacher> getAllTeachers(){
        return teacherService.getTeachers();
    }
    @PostMapping("")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.addTeacher(teacher);
    }
}
