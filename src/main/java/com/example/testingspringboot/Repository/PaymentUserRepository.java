package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.PaymentUser;
import com.example.testingspringboot.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentUserRepository extends JpaRepository<PaymentUser, Long> {


}
