package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.CourseDetail;

import java.util.List;

public interface CourseDetailService {
    void deleteCourseDetail(long id);
    List<CourseDetail> getAllCourseDetail();
    CourseDetail saveCourseDetail(CourseDetail courseDetail);

    List<CourseDetail> getCourseDetialbyID(long id);

    CourseDetail editCourseDetail(CourseDetail courseDetail);
    CourseDetail updateClassRoom(CourseDetail courseDetail);
    CourseDetail editEmployee(CourseDetail courseDetail);
    //    Student search(Student student);
    List<CourseDetail>listAll(String keyword);
}
