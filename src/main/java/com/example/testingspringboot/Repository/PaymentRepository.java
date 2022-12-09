package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.PaymentUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentUser, Long> {
}
