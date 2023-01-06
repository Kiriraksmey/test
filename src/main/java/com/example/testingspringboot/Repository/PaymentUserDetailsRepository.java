package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.PaymentUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentUserDetailsRepository extends JpaRepository<PaymentUserDetails, Long> {
    List<PaymentUserDetails> getAllCourseByUserId(Long userId);
}