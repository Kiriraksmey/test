package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> findAllUsers() ;

    public Optional<User> findUserById(long id);

    public User findByUserName(String name) ;
    public User saveUser(User newUser);


}
