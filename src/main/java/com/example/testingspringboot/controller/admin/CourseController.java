package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.entities.course;
import com.example.testingspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/")
public class CourseController {

    @Autowired
    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/courseList")
    public String listEmployee(Model model) {
        model.addAttribute("courses", courseService.getAllCourse());
        return "course";
    }
    @GetMapping("/deletecourse/{id}")
    public String deleteStudent(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/system/courseList";
    }

    @GetMapping("/create-course")
    public String createEmployee(Model model) {
        return "course/courseCreate";
    }

    @PostMapping("/saveCourse")
    public String saveEmploye(@ModelAttribute("course") course course) {
        courseService.saveCourse(course);
        return "redirect:/system/courseList";
    }

    @GetMapping("editCourse/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCoursebyID(id));
        return "employee/edit";

    }

    @PostMapping("updateCourse/{id}")
    public String updateStudent(@PathVariable Long id, course course) {
        courseService.saveCourse(course);
        return "redirect:/system/coursetList";

    }
    @PostMapping("/employe/{id}")
    public String updateClassRoom(@PathVariable long id, @ModelAttribute("course") course course, Model model) {
        com.example.testingspringboot.entities.course existingEmployee = courseService.getCoursebyID(id);
        existingEmployee.setImage(course.getImage());
        existingEmployee.setCourseName(course.getCourseName());
        existingEmployee.setIntroduce(course.getIntroduce());
        existingEmployee.setTitle(course.getTitle());

        return "redirect:/system/employee";
    }

//    @PostMapping("/studentList")
//    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//        List<course> listStudents = courseService.listAll(keyword);
//        model.addAttribute("courses", listStudents);
////        model.addAttribute("keyword", keyword);
//        return "course";
//    }
}
