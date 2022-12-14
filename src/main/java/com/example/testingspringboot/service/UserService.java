package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.User;

public interface UserService {
    User findUserByEmail(String email);
}
