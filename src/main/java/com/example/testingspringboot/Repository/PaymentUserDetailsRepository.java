package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.PaymentUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentUserDetailsRepository extends JpaRepository<PaymentUserDetails, Long> {
}