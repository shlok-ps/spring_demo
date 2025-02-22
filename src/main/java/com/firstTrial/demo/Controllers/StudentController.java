package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.Entities.Student;
import com.firstTrial.demo.Services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> getAllStudents(){
        log.info("Fetching all students");
        return studentService.getStudents();
    }

    @PostMapping("")
    public Student addStudent(@RequestBody Student student){
        log.info("Adding student: {}", student);
        return studentService.addStudent(student);
    }
}
