package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.Entities.Student;
import com.firstTrial.demo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentService.getStudents();
    }
    @PostMapping("")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

}
