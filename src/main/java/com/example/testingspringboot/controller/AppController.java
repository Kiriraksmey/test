package com.example.testingspringboot.controller;


import com.example.testingspringboot.Repository.UserRepository;
import com.example.testingspringboot.entities.PaymentUser;
import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.entities.UserResponeBody;
import com.example.testingspringboot.service.CourseService;
import com.example.testingspringboot.service.PaymentUserService;
import com.example.testingspringboot.service.StudentService;
import com.example.testingspringboot.service.UserService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private final UserService userService;
    @Autowired
    private final CourseService courseService;
    @Autowired
    private final StudentService studentService;

    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    public AppController(UserService userService, CourseService courseService, StudentService studentService) {
        this.userService = userService;
        this.courseService = courseService;
        this.studentService = studentService;

    }

    public User getSession() {
        HttpSession session = httpSessionFactory.getObject();
        return (User) session.getAttribute("userSession");
    }


    @GetMapping("/course")
    public String course(Model model) {
//        model.addAttribute("user", new User());

        return "front-end/course/list";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";  //Where you go after logout here.
    }

    @GetMapping("/login")
    public String login(Model model) {
        UserResponeBody responseBody = new UserResponeBody();
        responseBody.setErrorCode("02");
        responseBody.setErrorMessage("");
        model.addAttribute("responseBody", responseBody);
        return "frontend/login/login";
    }

    @PostMapping("/login")
    public String loginPage(Model model, User user) {

        HttpSession session = httpSessionFactory.getObject();

        UserResponeBody responseBody = new UserResponeBody();
        User list = userRepo.findUserByEmail(user.getEmail());
        if (list == null) {
            responseBody.setErrorCode("01");
            responseBody.setErrorMessage("Wrong email or password !");
            model.addAttribute("responseBody", responseBody);
            return "frontend/login/login";
        }
        String userEnteredPasswordWithoutEncryted = user.getPassword();
        String encryptedPasswordFromDb = list.getPassword();
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        boolean isPasswordMatches = bcrypt.matches(userEnteredPasswordWithoutEncryted, encryptedPasswordFromDb);
        if (!isPasswordMatches) {
            responseBody.setErrorCode("01");
            responseBody.setErrorMessage("Wrong email or password !");
            model.addAttribute("responseBody", responseBody);
            model.addAttribute("responseBody", responseBody);
            return "frontend/login/login";
        }
        session.setAttribute("userSession", list);
        session.setAttribute("name", list.getName());
        model.addAttribute("responseBody", responseBody);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String createEmployee(Model model) {
        model.addAttribute("user", new User());
        return "Register";
    }

    @GetMapping("/testSession")
    public String testSession(Model model) {

        HttpSession session = httpSessionFactory.getObject();
        User userName = (User) session.getAttribute("userName");

        model.addAttribute("user", new User());
        return "Register";
    }


    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setUserType(true);

        userRepo.save(user);

        return "register_success";
    }


}