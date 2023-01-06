package com.example.testingspringboot.service;

import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.CourseSearch;
import com.example.testingspringboot.entities.Video;

import java.util.List;

public interface CourseDetailService {
    void deleteCourseDetail(long id);
    List<CourseDetail> getAllCourseDetail();
    CourseDetail saveCourseDetail(CourseDetail courseDetail);

    List<CourseDetail> getCourseDetailByID(long id);

    List<CourseDetail> getCourseDetailByStudentID(long id, long studentId);
    Double getTotalPriceCourse(List<Long> id);
    Video findDefaultVideo(long id);

    CourseDetail editCourseDetail(CourseDetail courseDetail);
    CourseDetail updateClassRoom(CourseDetail courseDetail);
    CourseDetail editEmployee(CourseDetail courseDetail);
    //    Student search(Student student);
    List<CourseDetail>listAll(String keyword);
}
