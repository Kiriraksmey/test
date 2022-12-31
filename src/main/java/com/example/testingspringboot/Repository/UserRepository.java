package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1 and userType=1")
    public User findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.email = ?1 and userType=1")
    public User findUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1 and userType=1")
    public User existByEmail(String email);
}