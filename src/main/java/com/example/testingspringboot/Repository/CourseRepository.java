package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
//    @Query("SELECT p FROM Course p WHERE "
//            + "CONCAT(p.title,  p.introduce ) LIKE %?1%")

//    public List<Course> search(String keyword);
}
