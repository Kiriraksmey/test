package com.example.testingspringboot.service;

import com.example.testingspringboot.Repository.StudentRepository;
import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getStudent(){
        List<Student> student = repository.findAll();
        return student;
    }

}
