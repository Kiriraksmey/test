package com.example.testingspringboot.service;

import com.example.testingspringboot.Repository.LoginRepository;
import com.example.testingspringboot.entities.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository repo;

    public Login login(String name, String pass, String status) {
        Login user = repo.findByNameAndPassAndStatus(name, pass, status);
        return user;
    }
}
