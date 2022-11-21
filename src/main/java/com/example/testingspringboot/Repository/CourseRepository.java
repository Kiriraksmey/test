package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.entities.course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<course, Long> {
    @Query("SELECT p FROM course p WHERE "
            + "CONCAT(p.title,  p.introduce ) LIKE %?1%")

    public List<course> search(String keyword);
}
