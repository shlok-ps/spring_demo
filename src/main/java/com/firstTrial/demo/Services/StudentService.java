package com.firstTrial.demo.Services;

import com.firstTrial.demo.Entities.Student;
import com.firstTrial.demo.Repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        log.info("Fetching all students");
        List<Student> students = studentRepository.findAll();
        log.info("Found {} students", students.size());
        return students;
    }

    public Student updateStudent(Student student) {
        log.info("Updating student: {}", student);
        try {
            if (student.getId() == null || !studentRepository.existsById(student.getId())) {
                log.warn("Student not found with id: {}", student.getId());
                throw new Exception("Student not found");
            }
            Student updatedStudent = studentRepository.save(student);
            log.info("Student updated successfully: {}", updatedStudent);
            return updatedStudent;
        } catch (Exception ex) {
            log.error("Error while updating student: {}. Exception: {}", student, ex.getMessage(), ex);
            return null;
        }
    }

    public void deleteStudent(UUID id) {
        log.info("Deleting student with id: {}", id);
        try {
            if (!studentRepository.existsById(id)) {
                log.warn("Student not found with id: {}", id);
                throw new Exception("Student not found");
            }
            studentRepository.deleteById(id);
            log.info("Student deleted successfully with id: {}", id);
        } catch (Exception ex) {
            log.error("Error while deleting student with id: {}. Exception: {}", id, ex.getMessage(), ex);
        }
    }

    public Student addStudent(Student student) {
        log.info("Attempting to add student: {}", student);
        try {
            // Check if the student already exists (if ID is not null)
            if (student.getId() != null && studentRepository.existsById(student.getId())) {
                log.warn("Student already exists with id: {}", student.getId());
                throw new Exception("Student already exists");
            }
            Student savedStudent = studentRepository.save(student);
            log.info("Successfully added student: {}", savedStudent);
            return savedStudent;
        } catch (Exception ex) {
            log.error("Error while adding student: {}. Exception: {}", student, ex.getMessage(), ex);
            // Optionally, rethrow the exception or handle it further.
            return null;
        }
    }
}
