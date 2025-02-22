package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.Entities.Student;
import com.firstTrial.demo.Services.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        log.info("API call: getAllStudents");
        return studentService.getStudents();
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        log.info("API call: addStudent - {}", student);
        return studentService.addStudent(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        log.info("API call: updateStudent - {}", student);
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable UUID id) {
        log.info("API call: deleteStudent with id: {}", id);
        studentService.deleteStudent(id);
        return "Student deleted with id: " + id;
    }
}
