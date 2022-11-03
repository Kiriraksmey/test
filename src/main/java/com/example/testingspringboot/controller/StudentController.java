package com.example.testingspringboot.controller;

import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index(Model model){

        return "/index";
    }
    @GetMapping("/getTest")
    public String getTest(Model model){
        String text = "Hello Test";

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
        return "redirect:/studentList";
    }


    @GetMapping("/create-employee")
    public String createEmployee(Model model) {
        return "employee/create";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/studentList";
    }
    @GetMapping("editEmployee/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentbyID(id));
        return "employee/edit";

    }

    @PostMapping("updateStudent/{id}")
    public String updateStudent(@PathVariable Long id, Student student) {
        studentService.saveStudent(student);
        return "redirect:/studentList";

    }


    @PostMapping("/employee/{id}")
    public String updateClassRoom(@PathVariable long id, @ModelAttribute("student") Student student, Model model) {
        com.example.testingspringboot.entities.Student existingEmployee = studentService.getStudentbyID(id);
        existingEmployee.setAge(student.getAge());
        existingEmployee.setGender(student.getGender());
        existingEmployee.setName(student.getName());
        return "redirect:/employee";
    }



    public int test(){
        int ab = 10;
        int ac = 90;

        int sum = test1(ab,ac);

        return sum;
    }

    public int test1(int q , int e){
        return q+e;
    }
}
