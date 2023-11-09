package com.firstTrial.demo.Repositories;

import com.firstTrial.demo.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
