package com.example.testingspringboot.controller.fontEnd;


import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.entities.User;
import com.example.testingspringboot.service.*;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    private final ObjectFactory<HttpSession> httpSessionFactory;

  
    //
    public MainController(StudentService studentService, CourseService courseService, VideoService videoService, DescriptionService descriptionService, CourseDetailService courseDetailService, ObjectFactory<HttpSession> httpSessionFactory) {
        this.studentService = studentService;

        this.courseService = courseService;
        this.videoService = videoService;
        this.descriptionService = descriptionService;
        this.courseDetailService = courseDetailService;
        this.httpSessionFactory = httpSessionFactory;
    }

    @GetMapping("/")
    public String homePage(Model model,  HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute("sessionMessages", messages);


        model.addAttribute("courses", courseService.getAllCourse());
        //return "course";
        model.addAttribute("students", studentService.getAllStudent());

        return "/index";
    }




    @RequestMapping("/viewCourseDetailDOC/{id}")
    public String viewDetailDOC(Model model, @PathVariable Long id) {

        model.addAttribute("course", courseService.getCourseById(id));
//        model.addAttribute("descriptions", descriptionService.getDescriptionById(id));

        List<CourseDetail> listDetail = courseDetailService.getCourseDetailByID(id);
        model.addAttribute("courseDetail", listDetail);
        model.addAttribute("videoDefault", courseDetailService.findDefaultVideo(id));
        return "/frontend/course/course-detail";

    }
    @RequestMapping("/viewCourseByStudent/{course_id}")
    public String viewCourseByStudent(Model model, @PathVariable Long course_id) {
        HttpSession session = httpSessionFactory.getObject();
        User user = (User) session.getAttribute("userSession");
        Long userId = user != null ? user.getId() : 0L;
        model.addAttribute("course", courseService.getCourseById(course_id));
        model.addAttribute("descriptions", descriptionService.getDescriptionById(course_id));

        List<CourseDetail> listDetail = courseDetailService.getCourseDetailByStudentID(course_id,userId);
        model.addAttribute("courseDetail", listDetail);
        model.addAttribute("videoDefault", courseDetailService.findDefaultVideo(course_id));
        return "/frontend/course/course-detail-by-student";

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
