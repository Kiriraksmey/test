package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.entities.VerifyToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifyTokenRepository extends JpaRepository<VerifyToken, Long> {
//    VerifyToken findByToken(String token);
//    VerifyToken findByUser(User user);
}
