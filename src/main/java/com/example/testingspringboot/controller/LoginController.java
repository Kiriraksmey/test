package com.example.testingspringboot.controller;

import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.service.LoginService;
import com.example.testingspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private LoginService userService;

    @Autowired
    private StudentService studentService;


    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user ) {

        Login authUser = userService.login(user.getName(), user.getPass(), user.getStatus());


        System.out.print(authUser);
        if(Objects.nonNull(authUser))
        {

            return "redirect:/";


        } else {
            return "redirect:/login";


        }


    }
    @GetMapping("/get")
    public ModelAndView getStudent() {
        ModelAndView mav = new ModelAndView("get-student");

        List<Student> result = studentService.getStudent();
        mav.addObject("students",result);
        return mav;
    }
    public  String getStudent(Model model){
        Student student = new Student();


        return null;







    }
}
