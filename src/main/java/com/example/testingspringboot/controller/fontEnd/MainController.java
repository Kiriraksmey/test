package com.example.testingspringboot.controller.fontEnd;


import com.example.testingspringboot.service.CourseService;
import com.example.testingspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 @Controller
public class MainController {
    @Autowired
    private final StudentService studentService;
    private final CourseService courseService;
//
    public MainController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;

        this.courseService = courseService;
    }
    @RequestMapping("/")
    public String homePage(Model model){

        model.addAttribute("courses", courseService.getAllCourse());
        //return "course";
        model.addAttribute("students", studentService.getAllStudent());
        return  "/index";
    }
    @RequestMapping("/viewDetailDOC")
    public String viewDetailDOC(Model model){

        model.addAttribute("students", studentService.getAllStudent());
        return  "/course/student";
    }
     @RequestMapping("/profile")
     public String viewProfile(Model model){

         model.addAttribute("students", studentService.getAllStudent());
         return  "/frontend/student/account";
     }

//     @RequestMapping("/editProfile")
//     public String editPage(Model model){
//
//         model.addAttribute("students", studentService.getAllStudent());
//         //return "course";
//         //model.addAttribute("students", studentService.getAllStudent());
//         return  "/editProfile";
//     }
//     @RequestMapping("/editProfile")
//     public String editProfile(Model model){
//
//         model.addAttribute("students", studentService.getAllStudent());
//         return  "frontend/student/editAccount";
//     }
}
