package com.example.testingspringboot.controller.fontEnd;

import com.example.testingspringboot.service.CourseDetailService;
import com.example.testingspringboot.service.CourseService;
import com.example.testingspringboot.service.StudentService;
import com.example.testingspringboot.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @Autowired
    private final StudentService studentService;
    private final CourseService courseService;
    private final VideoService videoService;

    private final CourseDetailService courseDetailService;

    public RegisterController(StudentService studentService, CourseService courseService, VideoService videoService, CourseDetailService courseDetailService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.videoService = videoService;
        this.courseDetailService = courseDetailService;
    }

    @RequestMapping("/register")
    public String homePage(Model model){

        model.addAttribute("courses", courseService.getAllCourse());
        //return "course";
        model.addAttribute("students", studentService.getAllStudent());

        return  "/frontend/register/Register";
    }


}
