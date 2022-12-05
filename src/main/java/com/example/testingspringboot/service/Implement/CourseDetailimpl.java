package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.CourseDetailRepiository;
import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.CourseSearch;
import com.example.testingspringboot.entities.Video;
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
    public List<CourseDetail> getCourseDetailByID(long id) {
        return courseDetailRepiository.getCourseDetailByCourseId(id);
    }
    @Override
    public Video findDefaultVideo(long id) {
        return courseDetailRepiository.findDefaultVideo(id);
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

    @Override
    public Double getTotalPriceCourse(List<Long> id) {
        return courseDetailRepiository.getTotalPriceCourse(id);
    }
}
