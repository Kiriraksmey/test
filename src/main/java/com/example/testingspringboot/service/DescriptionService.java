package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.Description;

import java.util.List;

public interface DescriptionService {
    void deleteDescription(long id);
    List<Description> getAllDescription();
    Description saveDescription(Description description);

    //   Course getCoursebyID(long id);
    Description getDescriptionById(Long id);


    Description editDescription(Description description);
    Description updateClassRoom(Description description);
    Description editEmployee(Description description);
    //    Student search(Student student);
    List<Description>listAll(String keyword);
}
