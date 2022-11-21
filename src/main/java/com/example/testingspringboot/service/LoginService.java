package com.example.testingspringboot.service;

import com.example.testingspringboot.Repository.LoginRepository;
import com.example.testingspringboot.entities.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository repo;

    public Login login(String name, String pass) {
        Login user = repo.findByNameAndPass(name, pass);
        return user;
    }
//    public  Login register(String name , String pass, int id,String status){
//        Login user = repo.findByNameAndPassAndidAndStatus(name, pass,id,status);
//        return user;
//
//    }

}
