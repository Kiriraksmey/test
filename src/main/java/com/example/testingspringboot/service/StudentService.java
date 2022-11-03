package com.example.testingspringboot.service;

import com.example.testingspringboot.Repository.StudentRepository;
import com.example.testingspringboot.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {



//    public String deleteStudent(Long id){
//         repository.deleteById(id);
//        return "success";
//
//    }

//
//    public Student getStudentbyID(long id) {
//        return null;
//    }
//   public Student saveStudent(Student student){
//        return student;
//    }
//    public  List<Student>getAllStudent(){
//        List<Student> student = repository.findAll();
//        return student;
//    }
//    public Student updateClassRoom(Student student){
//
//        return student;
//    }
    void deleteStudent(long id);
    List<Student>getAllStudent();
    Student saveStudent(Student student);

    Student getStudentbyID(long id);

    Student editStudent(Student student);
    Student updateClassRoom(Student student);
    Student editEmployee(Student student);

}
