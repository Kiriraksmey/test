package com.example.testingspringboot.entities;

import javax.persistence.*;

@Entity
@Table(name="login")
public class Login {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;
    private String name;
    private String pass;
    private  String status;


    public Login() {
    }

    public Login(Long id, String name, String pass, String status) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.status = status;
    }



    public void setId(Long id) {
        this.id = id;
    }
    public  Long getId(){return  id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status= status;
    }



}
