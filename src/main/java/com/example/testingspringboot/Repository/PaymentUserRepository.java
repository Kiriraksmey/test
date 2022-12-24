package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.PaymentUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentUserRepository extends JpaRepository<PaymentUser, Long> {
}
