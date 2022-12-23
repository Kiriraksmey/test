package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.entities.Video;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);
    void deleteUser(long id);
    List<User> getAllUser();
    User saveUser(User user);

    List<User> getListUser(long id);
    User getUserById(Long id);
    User editVideo(User user);
    User updateClassRoom(User user);
    User editEmployee(User user);
    //    Student search(Student student);
    List<User>listAll(String keyword);
}
