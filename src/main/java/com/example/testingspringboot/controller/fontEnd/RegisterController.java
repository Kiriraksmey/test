package com.example.testingspringboot.controller.fontEnd;

import com.example.testingspringboot.entities.PaymentUser;
import com.example.testingspringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @Autowired
    private final StudentService studentService;
    private final CourseService courseService;
    private final VideoService videoService;
    private final PaymentUserService paymentUserService;

    private final CourseDetailService courseDetailService;

    public RegisterController(StudentService studentService, CourseService courseService, VideoService videoService, PaymentUserService paymentUserService, CourseDetailService courseDetailService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.videoService = videoService;
        this.paymentUserService = paymentUserService;
        this.courseDetailService = courseDetailService;
    }

    @RequestMapping("/register_permission")
    public String homePage(Model model){

        model.addAttribute("courses", courseService.getAllCourse());
        //return "course";
        model.addAttribute("students", studentService.getAllStudent());
        model.addAttribute("payments", paymentUserService.getAllPaymentUser());

        return  "frontend/register/Register";
    }
//    @PostMapping("/savePayment")
//    public String saveEmploye(@ModelAttribute("payment") PaymentUser paymentUser) {
//        paymentUserService.savePaymentUser(paymentUser);
//        return "redirect:/payment";
//    }


}
