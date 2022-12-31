package com.example.testingspringboot.controller.fontEnd;

import com.example.testingspringboot.Repository.PaymentUserDetailsRepository;
import com.example.testingspringboot.Repository.PaymentUserRepository;
import com.example.testingspringboot.Repository.UserRepository;
import com.example.testingspringboot.entities.*;
import com.example.testingspringboot.service.CourseService;
import com.example.testingspringboot.service.PaymentUserService;

import com.example.testingspringboot.validator.PaymentUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PaymentController implements WebMvcConfigurer {
    @Autowired
    private final PaymentUserService paymentUserService;
    private final UserRepository userRepository;
    private final CourseService courseService;
    private final PaymentUserRepository paymentUserRepository;

    private final PaymentUserValidator paymentUserValidator;
//    private final UserValidator userValidator;
    @Autowired
    private PaymentUserDetailsRepository paymentUserDetailsRepository;

    public PaymentController(PaymentUserService paymentUserService, UserRepository userRepository, CourseService courseService, PaymentUserRepository paymentUserRepository, PaymentUserValidator paymentUserValidator) {
        this.paymentUserService = paymentUserService;
        this.userRepository = userRepository;
        this.courseService = courseService;
        this.paymentUserRepository = paymentUserRepository;
//        this.userValidator = userValidator;
        this.paymentUserValidator = paymentUserValidator;
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/paymentsucess")
    public String createEmploye(Model model) {
        return "frontend/payment/paymentSucess";
    }
    @GetMapping("/payment")
    public String listEmployee(Model model) {
        List list = paymentUserService.getAllPaymentUser();
        model.addAttribute("payments", paymentUserService.getAllPaymentUser());

        return "frontend/payment/payment";
    }


//    @PostMapping("/savePaymentUser")
//    public String saveEmploye(@ModelAttribute("payment") PaymentUser paymentUser) {
//        paymentUserService.savePaymentUser(paymentUser);
//        return "redirect:/frontend/payment/payment";
//    }
//    @PostMapping("/savePaymentRegister")
//    public String saveEmploy(@ModelAttribute("payments") PaymentUser paymentUser) {
//        String a = "sd";
//        paymentUserService.savePaymentUser(paymentUser);
//        return "redirect:/payment";
//    }

    @PostMapping("/savePaymentRegister")
    public String processRegister(@Valid PaymentUser paymentUser, BindingResult bindingResult, Model model) {
    // validation user ============================
        UserResponeBody responseBody = new UserResponeBody();
//        userValidator.validate(paymentUser,bindingResult);
        boolean checkEmail =  paymentUserValidator.isValid(paymentUser.getEmail());
        if (checkEmail) {
            responseBody.setErrorCode("01");
            responseBody.setErrorMessage("Error ");
            model.addAttribute("responseBody", responseBody);
            model.addAttribute("courses", courseService.getAllCourse());
            return  "frontend/register/Register";
        }
        User user = new User();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(paymentUser.getPassword());
        // ============= user with login ===================
        user.setName(paymentUser.getUserName());
        user.setEmail(paymentUser.getEmail());
        user.setPassword(encodedPassword);
        // ============= user with login ===================

        user.setUserType(true);
        userRepository.save(user);
        if(user != null){
            if(paymentUser.getCourseId().size() > 0 && !paymentUser.getCourseId().isEmpty()){
                for(int i = 0; i < paymentUser.getCourseId().size() ; i++){
                    Course course = courseService.getCourseById(Long.parseLong(paymentUser.getCourseId().get(i)));
                    PaymentUserDetails paymentUserDetails = new PaymentUserDetails();
                    paymentUserDetails.setUserId(user.getId());
                    paymentUserDetails.setCourserId(Long.parseLong(paymentUser.getCourseId().get(i)));
                    paymentUserDetails.setPrice(course != null ? course.getPrice() : 0D);
                    paymentUserDetailsRepository.save(paymentUserDetails);
                }
            }
        }
        paymentUserRepository.save(paymentUser);
        return "redirect:/payment";
    }

}
