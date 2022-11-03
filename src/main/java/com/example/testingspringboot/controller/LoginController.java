package com.example.testingspringboot.controller;

import com.example.testingspringboot.Repository.StudentRepository;
import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.service.LoginService;
import com.example.testingspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private LoginService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user) {
        Login authUser = userService.login(user.getName(), user.getPass());
        if (Objects.nonNull(authUser)) {
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }



}
