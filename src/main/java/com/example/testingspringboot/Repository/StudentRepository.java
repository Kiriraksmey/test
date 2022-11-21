package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    Student deleteById (Long id);
@Query("SELECT p FROM Student p WHERE "
        + "CONCAT(p.age,  p.name, p.gender) LIKE %?1%")

public List<Student> search(String keyword);

}
