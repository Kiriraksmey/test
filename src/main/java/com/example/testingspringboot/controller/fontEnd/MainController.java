package com.example.testingspringboot.controller.fontEnd;


import com.example.testingspringboot.entities.Course;
import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.CourseSearch;
import com.example.testingspringboot.response.AjaxCourseResponseBody;
import com.example.testingspringboot.service.*;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private final StudentService studentService;
    private final CourseService courseService;
    private final VideoService videoService;
    private final DescriptionService descriptionService;

    private final CourseDetailService courseDetailService;


  
    //
    public MainController(StudentService studentService, CourseService courseService, VideoService videoService, DescriptionService descriptionService, CourseDetailService courseDetailService) {
        this.studentService = studentService;

        this.courseService = courseService;
        this.videoService = videoService;
        this.descriptionService = descriptionService;
        this.courseDetailService = courseDetailService;
    }

    @GetMapping("/")
    public String homePage(Model model) {

        model.addAttribute("courses", courseService.getAllCourse());
        //return "course";
        model.addAttribute("students", studentService.getAllStudent());

        return "/index";
    }




    @RequestMapping("/viewCourseDetailDOC/{id}")
    public String viewDetailDOC(Model model, @PathVariable Long id) {

        model.addAttribute("course", courseService.getCourseById(id));
        model.addAttribute("descriptions", descriptionService.getDescriptionById(id));

        List<CourseDetail> listDetail = courseDetailService.getCourseDetailByID(id);
        model.addAttribute("courseDetail", listDetail);
        model.addAttribute("videoDefault", courseDetailService.findDefaultVideo(id));
        return "/frontend/course/course-detail";

    }

    @RequestMapping("/index")
    public String viewDetailDOCsss() {

        return "index";

    }

    @RequestMapping("/profile")
    public String viewProfile(Model model) {

        model.addAttribute("students", studentService.getAllStudent());
        return "/frontend/student/account";
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
