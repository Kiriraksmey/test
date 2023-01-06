package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.CourseRepository;
import com.example.testingspringboot.Repository.PaymentUserDetailsRepository;
import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.PaymentUserDetails;
import com.example.testingspringboot.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class Courseimpl implements CourseService {
    private final CourseRepository courseRepository;
    private final PaymentUserDetailsRepository paymentUserDetailsRepository;

    public Courseimpl(CourseRepository courseRepository, PaymentUserDetailsRepository paymentUserDetailsRepository) {
        this.courseRepository = courseRepository;
        this.paymentUserDetailsRepository = paymentUserDetailsRepository;
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
    public Course getCourseById(Long id) {
        Course lst = courseRepository.findById(id).get();
        return  lst;
    }

//    @Override
//    public Course getCourseById(long id) {
//        Course lst = courseRepository.findById(id).get();
//        return  lst;
//    }

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

    @Override
    public List<Course> getAllCourseByUserId(Long userId) {
        try{
            List<Course> courseList = new ArrayList<>();
            if (userId == null){
                return null;
            }
            List<PaymentUserDetails> list = paymentUserDetailsRepository.getAllCourseByUserId(userId);
            if (list != null){
                for (PaymentUserDetails lst : list){
                    Long id = lst.getCourserId();
                    Course listCourse = courseRepository.findById(lst.getCourserId()).get();
                    courseList.add(listCourse);
                }
            }

            System.out.println("List of UserCourse"+list);
            return courseList;

        }catch(Exception ex){
            throw ex;
        }

    }
}
