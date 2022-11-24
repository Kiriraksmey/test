package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.CourseRepository;
import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Courseimpl implements CourseService {
    private final CourseRepository courseRepository;

    public Courseimpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void deleteCourse(long id) {
         courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCoursebyID(long id) {
        Course lst = courseRepository.findById(id).get();
        return  lst;
    }

    @Override
    public Course editCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateClassRoom(Course course) {
        return null;
    }

    @Override
    public Course editEmployee(Course course) {
        return null;
    }

    @Override
    public List<Course> listAll(String keyword) {
        return  null;
//        if (keyword != null) {
//            return courseRepository.search(keyword);
//        }
//        return courseRepository.findAll();
    }
}
