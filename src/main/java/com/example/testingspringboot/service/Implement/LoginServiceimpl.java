package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.LoginRepository;
import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.service.RegisterService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceimpl implements RegisterService {
    private final LoginRepository loginRepository;


    public LoginServiceimpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    @Override
    public Login registerUser(Login user) {
        return loginRepository.save(user);
    }
}
