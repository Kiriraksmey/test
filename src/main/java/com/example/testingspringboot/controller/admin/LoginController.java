package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.service.LoginService;
import com.example.testingspringboot.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequestMapping("/system/")
public class LoginController {

    @Autowired
    private LoginService userService;
    @Autowired
    private  RegisterService registerService;
    public LoginController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @GetMapping("/index")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", new Login());
        return mav;
    }


    @GetMapping("/login")
    public String index(Model model){

        return "/login/index";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user) {
        Login authUser = userService.login(user.getName(), user.getPass());
        if (Objects.nonNull(authUser)) {
            return "index";
        } else {
            return "redirect:/system/studentList";
        }
    }
    @GetMapping ("/register")
    public String createEmployee(Model model) {
        return "Register";
    }


    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") Login user) {
       // Encryption encryption = new Encryption();
       registerService.registerUser(user);
        return "redirect:/system/index";
    }
    @GetMapping("/getTest")
    public String getTest(Model model){

        return "test";
    }
}
