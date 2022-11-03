package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.StudentRepository;
import com.example.testingspringboot.entities.Student;
import com.example.testingspringboot.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceimpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentbyID(long id) {
        Student lst = studentRepository.findById(id).get();
        return  lst;
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateClassRoom(Student student) {
        return null;
    }

    @Override
    public Student editEmployee(Student student) {
        return null;
    }
}
