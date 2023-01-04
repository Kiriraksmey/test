package com.example.testingspringboot.controller.fontEnd;

import com.example.testingspringboot.entities.PaymentUserDetails;
import com.example.testingspringboot.service.CourseService;
import com.example.testingspringboot.service.PaymentUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PaymentUserDetailController {
    @Autowired
    private final PaymentUserDetailService paymentUserDetailService;
    @Autowired
    private final CourseService courseService;

    public PaymentUserDetailController(PaymentUserDetailService paymentUserDetailService, CourseService courseService) {
        this.paymentUserDetailService = paymentUserDetailService;
        this.courseService = courseService;
    }
    @GetMapping("/mycourse")
    public String mycourse(Model model,  HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute("sessionMessages", messages);


        model.addAttribute("courses", courseService.getAllCourse());
        model.addAttribute("paymentuserdetails", paymentUserDetailService.getAllPaymentUserDetail());
        //return "course";


        return "frontend/student/mycourse";
    }

    @GetMapping("/deletePaymentUserDetail/{id}")
    public String deleteStudent(@PathVariable Long id) {
        paymentUserDetailService.deletePaymentUserDetail(id);
        return "redirect:/system/courseList";
    }

    @GetMapping("/create-course")
    public String createEmployee(Model model) {
        return "course/courseCreate";
    }

    @PostMapping("/saveCourse")
    public String saveEmploye(@ModelAttribute("course") PaymentUserDetails paymentUserDetail) {
        paymentUserDetailService.savePaymentUserDetails(paymentUserDetail);
        return "redirect:/system/courseList";
    }

    @GetMapping("editCourse/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("course", paymentUserDetailService.getPaymentUserDetailsById(id));
        return "course/courseEdit";

    }

    @PostMapping("/updateCourse/{id}")
    public String updateStudent(@PathVariable Long id, PaymentUserDetails paymentUserDetail) {
        paymentUserDetailService.savePaymentUserDetails(paymentUserDetail);
        return "redirect:/system/courseList";


    }


}
