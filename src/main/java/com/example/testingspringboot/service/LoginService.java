package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.Login;

import java.util.List;

public interface LoginService {
    void deleteLogin(long id);
    List<Login> getAllLogin();

    List<Login> getAllLogin(String name, String pass);

    Login saveLogin(Login login);

    //   Course getCoursebyID(long id);
    Login getCourseById(Long id);


    Login editCourse(Login login);
    Login updateClassRoom(Login login);
    Login editEmployee(Login login);
    //    Student search(Student student);
    List<Login>listAll(String keyword);
}
