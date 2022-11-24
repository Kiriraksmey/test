package com.example.testingspringboot.controller.fontEnd;

import com.example.testingspringboot.service.CourseService;
import com.example.testingspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseDetailController {
    @Autowired
    private final StudentService studentService;
    private final CourseService courseService;

    public CourseDetailController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }
    @GetMapping("/courseDetail")
    public String listEmployee(Model model) {
        model.addAttribute("courses", courseService.getAllCourse());
        return "course";
    }
}
