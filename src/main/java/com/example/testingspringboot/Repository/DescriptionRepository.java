package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {
}
