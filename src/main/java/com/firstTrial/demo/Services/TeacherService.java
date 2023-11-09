package com.firstTrial.demo.Services;

import com.firstTrial.demo.Entities.Teacher;
import com.firstTrial.demo.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
