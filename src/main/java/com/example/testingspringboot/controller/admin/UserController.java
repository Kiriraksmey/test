package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.Repository.UserRepository;
import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/")
public class UserController {
    @Autowired
    private final UserService userService;
    @Autowired
    private UserRepository userRepo;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @GetMapping("/users")
//    public String listUsers(Model model) {
//        List<User> listUsers = userRepo.findAll();
//        model.addAttribute("listUsers", listUsers);
//
//        return "User/addUsers";
//    }
    @GetMapping("/userList")
    public String listEmployee(Model model) {
        List list = userService.getAllUser();
        model.addAttribute("users", userService.getAllUser());
        return "User/index";
    }

    @GetMapping("/deletecUser/{id}")
    public String deleteStudent(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/system/userList";
    }

    @GetMapping("/create-User")
    public String createEmployee(Model model) {
        return "User/addUsers";
    }

    @PostMapping("/saveUser/{id}")
    public String saveEmploye(@ModelAttribute("users") User user) {
        userService.saveUser(user);
        return "redirect:/system/userList";
    }
    @GetMapping("editUser/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("users",userService.getUserById(id));
        return "User/edit";

    }


//    @GetMapping("editCourseDetail/{id}")
//    public String editStudent(@PathVariable Long id, Model model) {
//        model.addAttribute("course", courseDetailService.getCourseDetailbyID(id));
//        return "employee/edit";
//
//    }

    @PostMapping("/updateUser/{id}")
    public String updateStudent(@PathVariable Long id,User user) {
        userService .saveUser(user);
        return "redirect:/system/userList";

    }


}
