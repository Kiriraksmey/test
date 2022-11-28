package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.CourseDetailRepiository;
import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.service.CourseDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDetailimpl implements CourseDetailService {
    private final CourseDetailRepiository courseDetailRepiository;

    public CourseDetailimpl(CourseDetailRepiository courseDetailRepiository) {
        this.courseDetailRepiository = courseDetailRepiository;
    }

    @Override
    public void deleteCourseDetail(long id) {

    }

    @Override
    public List<CourseDetail> getAllCourseDetail() {
        return null;
    }

    @Override
    public CourseDetail saveCourseDetail(CourseDetail courseDetail) {
        return null;
    }

    @Override
    public List<CourseDetail> getCourseDetialbyID(long id) {
        return courseDetailRepiository.getCoursDetailByCourseId(id);
    }

    @Override
    public CourseDetail editCourseDetail(CourseDetail courseDetail) {
        return null;
    }

    @Override
    public CourseDetail updateClassRoom(CourseDetail courseDetail) {
        return null;
    }

    @Override
    public CourseDetail editEmployee(CourseDetail courseDetail) {
        return null;
    }

    @Override
    public List<CourseDetail> listAll(String keyword) {
        return null;
    }
}
