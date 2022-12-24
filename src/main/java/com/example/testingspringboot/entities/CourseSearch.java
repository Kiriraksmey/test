package com.example.testingspringboot.entities;

import java.util.List;

public class CourseSearch {

    private List courseId;

    public List getCourseId() {
        return courseId;
    }

    private String courseIdStr;

    public void setCourseId(List courseId) {
        this.courseId = courseId;
    }

    public String getCourseIdStr() {
        return courseIdStr;
    }

    public void setCourseIdStr(String courseIdStr) {
        this.courseIdStr = courseIdStr;
    }
}
