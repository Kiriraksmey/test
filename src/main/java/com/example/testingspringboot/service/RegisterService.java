package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.entities.Student;

public interface RegisterService {
    Login registerUser(Login user);
}
