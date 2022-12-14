package com.example.testingspringboot;

import com.example.testingspringboot.Repository.LoginRepository;
import com.example.testingspringboot.Repository.UserRepository;
import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.TRUE;
import java.util.Date;

@SpringBootApplication
public class TestingSpringBootApplication {
//    @Autowired
//    UserRepository userRepository;
//    LoginRepository loginRepository;
//    @PostConstruct
//    public void pupulate(){
//      //  List<User> users = new List<User>(Arrays.asList(1, "kiri", "email", "password", TRUE, "createDate", "updateDate", "user", TRUE));
//
//       // List<User> users = Arrays.asList(1,"kiri", "email", "password", TRUE, "createDate", "updateDate", "user", TRUE);
//        List<Login> users =new ArrayList<Login>();
//        users.add(new Login(1L, "kiri", "email", "password"));
//        loginRepository.saveAll(users);
//
//
//
//
//
//
//    }



    public static void main(String[] args) {
        SpringApplication.run(TestingSpringBootApplication.class, args);
    }

}
