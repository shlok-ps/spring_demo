package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.DemoApplication;
import com.firstTrial.demo.Entities.Student;
import com.firstTrial.demo.Services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.*;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("")
    public List<Student> getAllStudents(){
        Logger logger
                = Logger.getLogger(
                StudentController.class.getName());
        logger.info("Get All Students Received.");
        return studentService.getStudents();
    }
    @PostMapping("")
    public Student addStudent(@RequestBody Student student){
        Logger logger
                = Logger.getLogger(
                StudentController.class.getName());
        logger.info("Add Student Request Received {student}");
        return studentService.addStudent(student);
    }

}
