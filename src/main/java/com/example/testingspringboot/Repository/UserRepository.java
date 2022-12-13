package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByuserid(Long id);
    User findByUserName(String name);
}
