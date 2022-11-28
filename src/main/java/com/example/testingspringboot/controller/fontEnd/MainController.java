package com.example.testingspringboot.controller.fontEnd;


import com.example.testingspringboot.entities.CourseDetail;
import com.example.testingspringboot.service.CourseDetailService;
import com.example.testingspringboot.service.CourseService;
import com.example.testingspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 @Controller
public class MainController {
    @Autowired
    private final StudentService studentService;
    private final CourseService courseService;

    private final CourseDetailService courseDetailService;
//
    public MainController(StudentService studentService, CourseService courseService, CourseDetailService courseDetailService) {
        this.studentService = studentService;

        this.courseService = courseService;
        this.courseDetailService = courseDetailService;
    }
    @RequestMapping("/")
    public String homePage(Model model){

        model.addAttribute("courses", courseService.getAllCourse());
        //return "course";
        model.addAttribute("students", studentService.getAllStudent());

        return  "/index";
    }
    @RequestMapping("/viewCourseDetailDOC/{id}")
    public String viewDetailDOC(Model model,@PathVariable Long id){

        model.addAttribute("course", courseService.getCoursebyID(id));
        model.addAttribute("courseDetail", courseDetailService.getCourseDetialbyID(id));

        return  "/frontend/course/course-detail";
    }
     @RequestMapping("/index")
     public String viewDetailDOCsss(){

        return "index";

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
