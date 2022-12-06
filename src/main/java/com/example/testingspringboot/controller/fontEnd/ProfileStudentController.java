package com.example.testingspringboot.controller.fontEnd;

import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class ProfileStudentController {
    @Autowired
    private final StudentService studentService;

    public ProfileStudentController(StudentService studentService) {
        this.studentService = studentService;
    }
//    @GetMapping("/test")
//    public String list(Model model) {
//        model.addAttribute("students", studentService.getAllStudent());
//        return "test";
//    }
//    @GetMapping("/studentList")
//    public String listEmployee(Model model) {
//        model.addAttribute("students", studentService.getAllStudent());
//        return "employee/index";
//    }
//
//
//
//
    @PostMapping("/saveEmployee")
    public String saveEmploye(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/studentList";
    }

    @GetMapping("/updateProfile")
    public String listEmploye(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "frontend/student/editAccount";
    }

    @PostMapping("updatProfile/{id}")
    public String updateStudent(@PathVariable Long id, Student student) {
        studentService.saveStudent(student);
        return "redirect:/studentList";

    }

//    @RequestMapping("/")
//    public String homePage(Model model) {
//
//        model.addAttribute("students", studentService.getAllStudent());
//        return "/indexsss";
//    }

    @PostMapping("/employee/{id}")
    public String updateClassRoom(@PathVariable long id, @ModelAttribute("student") Student student, Model model) {
        com.example.testingspringboot.entities.Student existingEmployee = studentService.getStudentbyID(id);
        existingEmployee.setAge(student.getAge());
        existingEmployee.setGender(student.getGender());
        existingEmployee.setName(student.getName());
        existingEmployee.setAvtar(student.getAvtar());
        return "redirect:/studentList";
    }
//
//    @PostMapping("/studentList")
//    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//        List<Student> listStudents = studentService.listAll(keyword);
//        model.addAttribute("students", listStudents);
////        model.addAttribute("keyword", keyword);
//        return "employee/index";
//    }


    @GetMapping("/activated")
    public String saveEmploy(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "/frontend/course/activated";
    }
    @GetMapping("/login")
    public String savEmploy(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "/frontend/course/login";
    }

}
