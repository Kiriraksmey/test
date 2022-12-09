package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.Course;

import java.util.List;

public interface PaymentUserService {
    void deleteCourse(long id);
    List<Course> getAllCourse();
    Course saveCourse(Course course);

    //   Course getCoursebyID(long id);
    Course getCourseById(Long id);


    Course editCourse(Course course);
    Course updateClassRoom(Course course);
    Course editEmployee(Course course);
    //    Student search(Student student);
    List<Course>listAll(String keyword);
}
