package com.example.testingspringboot.Repository;

import com.example.testingspringboot.entities.Login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByNameAndPass(String name, String pass);


}
