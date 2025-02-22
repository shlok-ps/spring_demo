package com.firstTrial.demo.Services;

import com.firstTrial.demo.Entities.Teacher;
import com.firstTrial.demo.Repositories.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        log.info("Fetching all teachers");
        List<Teacher> teachers = teacherRepository.findAll();
        log.info("Found {} teachers", teachers.size());
        return teachers;
    }

    public Teacher addTeacher(Teacher teacher) {
        log.info("Adding teacher: {}", teacher);
        try {
            if (teacher.getId() != null && teacherRepository.existsById(teacher.getId())) {
                log.warn("Teacher already exists with id: {}", teacher.getId());
                throw new Exception("Teacher already exists");
            }
            Teacher savedTeacher = teacherRepository.save(teacher);
            log.info("Teacher added successfully: {}", savedTeacher);
            return savedTeacher;
        } catch (Exception ex) {
            log.error("Error while adding teacher: {}. Exception: {}", teacher, ex.getMessage(), ex);
            return null;
        }
    }

    public Teacher updateTeacher(Teacher teacher) {
        log.info("Updating teacher: {}", teacher);
        try {
            if (teacher.getId() == null || !teacherRepository.existsById(teacher.getId())) {
                log.warn("Teacher not found with id: {}", teacher.getId());
                throw new Exception("Teacher not found");
            }
            Teacher updatedTeacher = teacherRepository.save(teacher);
            log.info("Teacher updated successfully: {}", updatedTeacher);
            return updatedTeacher;
        } catch (Exception ex) {
            log.error("Error while updating teacher: {}. Exception: {}", teacher, ex.getMessage(), ex);
            return null;
        }
    }

    public void deleteTeacher(UUID id) {
        log.info("Deleting teacher with id: {}", id);
        try {
            if (!teacherRepository.existsById(id)) {
                log.warn("Teacher not found with id: {}", id);
                throw new Exception("Teacher not found");
            }
            teacherRepository.deleteById(id);
            log.info("Teacher deleted successfully with id: {}", id);
        } catch (Exception ex) {
            log.error("Error while deleting teacher with id: {}. Exception: {}", id, ex.getMessage(), ex);
        }
    }
}
