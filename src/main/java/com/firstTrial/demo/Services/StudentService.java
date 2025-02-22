package com.firstTrial.demo.Services;

import com.firstTrial.demo.Entities.Student;
import com.firstTrial.demo.Repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        try {
            return studentRepository.save(student);
        } catch (Exception ex) {
            log.error("Error while adding student: {}", student, ex);
            throw ex;
        }
    }
}
