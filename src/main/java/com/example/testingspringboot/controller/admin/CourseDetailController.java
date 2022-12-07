package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.service.CourseDetailService;
import com.example.testingspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/")
public class CourseDetailController {
    @Autowired
    private final CourseDetailService courseDetailService;

    public CourseDetailController(CourseDetailService courseDetailService) {
        this.courseDetailService = courseDetailService;
    }


    @GetMapping("/courseDetailList")
    public String listEmployee(Model model) {
        List list = courseDetailService.getAllCourseDetail();
        model.addAttribute("courseDetails", courseDetailService.getAllCourseDetail());
        return "courseDetail";
    }

    @PostMapping("/courseDetailList")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<CourseDetail> listStudents = courseDetailService.listAll(keyword);
        model.addAttribute("courseDetails", listStudents);
//        model.addAttribute("keyword", keyword);
        return "frontend/course/course-detail";
    }


    @GetMapping("/deletecourseDetail/{id}")
    public String deleteStudent(@PathVariable Long id) {
        courseDetailService.deleteCourseDetail(id);
        return "redirect:/system/courseDetailList";
    }

    @GetMapping("/create-courseDetail")
    public String createEmployee(Model model) {
        return "courseDetail/courseDetailCreate";
    }

    @PostMapping("/saveCourseDetail/{id}")
    public String saveEmploye(@ModelAttribute("courseDetail") CourseDetail courseDetail) {
        courseDetailService.saveCourseDetail(courseDetail);
        return "redirect:/system/courseDetailList";
    }

//    @GetMapping("editCourseDetail/{id}")
//    public String editStudent(@PathVariable Long id, Model model) {
//        model.addAttribute("course", courseDetailService.getCourseDetailbyID(id));
//        return "employee/edit";
//
//    }

    @PostMapping("/updateCourseDetail")
    public String updateStudent(@PathVariable Long id, CourseDetail courseDetail) {
        courseDetailService.saveCourseDetail(courseDetail);
        return "redirect:/system/courseDetailtList";

    }

}
