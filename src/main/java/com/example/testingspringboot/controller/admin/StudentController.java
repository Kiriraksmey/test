package com.example.testingspringboot.controller.admin;

import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/system/")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/test")
    public String list(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "test";
    }
    @GetMapping("/studentList")
    public String listEmployee(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "employee/index";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/system/studentList";
    }

    @GetMapping("/create-employee")
    public String createEmployee(Model model) {
        return "employee/create";
    }

    @PostMapping("/saveEmployee")
    public String saveEmploye(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/system/studentList";
    }

    @GetMapping("editEmployee/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentbyID(id));
        return "employee/edit";

    }

    @PostMapping("updateStudent/{id}")
    public String updateStudent(@PathVariable Long id, Student student) {
        studentService.saveStudent(student);
        return "redirect:/system/studentList";

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
        return "redirect:/system/employee";
    }

    @PostMapping("/studentList")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Student> listStudents = studentService.listAll(keyword);
        model.addAttribute("students", listStudents);
//        model.addAttribute("keyword", keyword);
        return "employee/index";
    }


}
