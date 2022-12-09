package com.example.testingspringboot.controller.fontEnd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
    @GetMapping("/payment")
    public String createEmployee(Model model) {
        return "frontend/payment/payment";
    }
    @GetMapping("/paymentsucess")
    public String createEmploye(Model model) {
        return "frontend/payment/paymentSucess";
    }
}
