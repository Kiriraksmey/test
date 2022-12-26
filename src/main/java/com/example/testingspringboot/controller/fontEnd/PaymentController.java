package com.example.testingspringboot.controller.fontEnd;

import com.example.testingspringboot.entities.PaymentUser;
import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.service.PaymentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    private final PaymentUserService paymentUserService;

    public PaymentController(PaymentUserService paymentUserService) {
        this.paymentUserService = paymentUserService;
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
    @PostMapping("/savePaymentUser")
    public String saveEmploye(@ModelAttribute("payment") PaymentUser paymentUser) {
        paymentUserService.savePaymentUser(paymentUser);
        return "redirect:/frontend/payment/payment";
    }
}
