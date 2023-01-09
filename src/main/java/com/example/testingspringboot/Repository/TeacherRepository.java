package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
