package com.example.testingspringboot.validator;

import com.example.testingspringboot.Repository.PaymentUserRepository;
import com.example.testingspringboot.Repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class PaymentUserValidator {


    private final UserRepository userRepository;

    public PaymentUserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean isValid(String email) {
        return userRepository.existByEmail(email) != null ? true : false;
    }
}