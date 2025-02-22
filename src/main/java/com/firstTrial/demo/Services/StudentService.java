package com.firstTrial.demo.Services;

import com.firstTrial.demo.Entities.Student;
import com.firstTrial.demo.Repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
}
