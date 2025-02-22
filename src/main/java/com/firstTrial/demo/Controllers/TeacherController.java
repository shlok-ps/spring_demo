package com.firstTrial.demo.Controllers;

import com.firstTrial.demo.Entities.Teacher;
import com.firstTrial.demo.Services.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teachers")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public List<Teacher> getAllTeachers() {
        log.info("API call: getAllTeachers");
        return teacherService.getTeachers();
    }

    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        log.info("API call: addTeacher - {}", teacher);
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/update")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        log.info("API call: updateTeacher - {}", teacher);
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable UUID id) {
        log.info("API call: deleteTeacher with id: {}", id);
        teacherService.deleteTeacher(id);
        return "Teacher deleted with id: " + id;
    }
}
