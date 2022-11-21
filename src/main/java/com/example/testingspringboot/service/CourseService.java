package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.entities.course;

import java.util.List;

public interface CourseService {
    void deleteCourse(long id);
    List<course> getAllCourse();
    course saveCourse(course course);

   course getCoursebyID(long id);

   course editCourse(course course);
    course updateClassRoom(course course);
    course editEmployee(course course);
    //    Student search(Student student);
    List<course>listAll(String keyword);
}
