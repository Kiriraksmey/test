package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.CourseRepository;
import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.entities.course;
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
    public List<course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public course saveCourse(course course) {
        return courseRepository.save(course);
    }

    @Override
    public course getCoursebyID(long id) {
        course lst = courseRepository.findById(id).get();
        return  lst;
    }

    @Override
    public course editCourse(course course) {
        return courseRepository.save(course);
    }

    @Override
    public course updateClassRoom(course course) {
        return null;
    }

    @Override
    public course editEmployee(course course) {
        return null;
    }

    @Override
    public List<course> listAll(String keyword) {
        if (keyword != null) {
            return courseRepository.search(keyword);
        }
        return courseRepository.findAll();
    }
}
