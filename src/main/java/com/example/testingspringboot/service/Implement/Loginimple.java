package com.example.testingspringboot.service.Implement;

import com.example.testingspringboot.Repository.LoginRepository;
import com.example.testingspringboot.entities.Login;
import com.example.testingspringboot.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Loginimple implements LoginService {
    private final LoginRepository loginRepository;

    public Loginimple(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    public Login login(String name, String pass) {
        Login user = loginRepository.findByNameAndPass(name, pass);
        return user;
    }

    @Override
    public void deleteLogin(long id) {

    }

    @Override
    public List<Login> getAllLogin() {
        return null;
    }

    @Override
    public List<Login> getAllLogin(String name, String pass) {
        Login user = loginRepository.findByNameAndPass(name, pass);
        return (List<Login>) user;
    }

    @Override
    public Login saveLogin(Login login) {
        return null;
    }

    @Override
    public Login getCourseById(Long id) {
        return null;
    }

    @Override
    public Login editCourse(Login login) {
        return null;
    }

    @Override
    public Login updateClassRoom(Login login) {
        return null;
    }

    @Override
    public Login editEmployee(Login login) {
        return null;
    }

    @Override
    public List<Login> listAll(String keyword) {
        return null;
    }
//    public  Login register(String name , String pass, int id,String status){
//        Login user = repo.findByNameAndPassAndidAndStatus(name, pass,id,status);
//        return user;
//
//    }

}
