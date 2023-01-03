package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.CourseDetailRepository;
import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.Video;
import com.example.testingspringboot.service.CourseDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDetailimpl implements CourseDetailService {
    private final CourseDetailRepository courseDetailRepository;

    public CourseDetailimpl(CourseDetailRepository courseDetailRepository) {
        this.courseDetailRepository = courseDetailRepository;
    }

    @Override
    public void deleteCourseDetail(long id) {

    }

    @Override
    public List<CourseDetail> getAllCourseDetail() {
        return courseDetailRepository.findAll();
    }

    @Override
    public CourseDetail saveCourseDetail(CourseDetail courseDetail) {
        return courseDetailRepository.save(courseDetail);
    }

    @Override
    public List<CourseDetail> getCourseDetailByID(long id) {
        return courseDetailRepository.getCourseDetailByCourseId(id);
    }
    @Override
    public Video findDefaultVideo(long id) {
        return courseDetailRepository.findDefaultVideo(id);
    }

    @Override
    public CourseDetail editCourseDetail(CourseDetail courseDetail) {
        return courseDetailRepository.save(courseDetail);
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
        return courseDetailRepository.getTotalPriceCourse(id);
    }
}
