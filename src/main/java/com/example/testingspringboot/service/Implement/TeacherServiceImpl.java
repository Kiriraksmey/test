package com.example.testingspringboot.service.Implement;


import com.example.testingspringboot.Repository.TeacherRepository;
import com.example.testingspringboot.entities.Teacher;
import com.example.testingspringboot.service.TeacherService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }
}
