package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.service.Implement.Loginimple;
import com.example.testingspringboot.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;
@Controller
public class test {
    @Autowired
    private Loginimple userService;
    @Autowired
    private RegisterService registerService;
    @PostMapping("/ttt")
    public String loginsdfsd(@ModelAttribute("user") Login user) {
        Login authUser = userService.login(user.getName(), user.getPass());
        if (Objects.nonNull(authUser)) {
            return "index";
        } else {
            return "redirect:/system/studentList";
        }
    }
    @GetMapping("test")
    public String tes(){
        return null;
    }

}
