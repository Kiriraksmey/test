package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.entities.UserResponeBody;
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
    private final LoginService loginService;
    @Autowired
    private  RegisterService registerService;
    public LoginController(LoginService loginService, RegisterService registerService) {
        this.loginService = loginService;
        this.registerService = registerService;
    }
    @GetMapping("/index")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", new Login());
        return mav;
    }
    @GetMapping("/login")
    public String login(Model model) {
        UserResponeBody responseBody = new UserResponeBody();
        responseBody.setErrorCode("02");
        responseBody.setErrorMessage("");
        model.addAttribute("responseBody", responseBody);
        return "/login/index";
    }
//    @PostMapping("/login")
//    public String login(@ModelAttribute("user") Login login) {
//        Login authUser = (Login) loginService.getAllLogin(login.getName(), login.getPass());
//        if (Objects.nonNull(authUser)) {
//            return "index";
//        } else {
//            return "redirect:/system/studentList";
//        }
//    }


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
    @GetMapping("")
    public String main(){
        return "layout/dashboard";
    }
}
