//package com.example.testingspringboot.entities;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "user")
//public class User {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private String userid;
//    private String email;
//    private  String firstName;
//    private String  lastName;
//    private  boolean enable;
//    private  String password;
//    private  String address;
//
//
//
//    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes
//
//
//    public User() {
//    }
//
//    public User(String userid, String email, String firstName, String lastName, boolean enable, String password, String address) {
//        this.userid = userid;
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.enable = enable;
//        this.password = password;
//        this.address = address;
//    }
//
//    public String getUserid() {
//        return userid;
//    }
//
//    public void setUserid(String userid) {
//        this.userid = userid;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public boolean isEnable() {
//        return enable;
//    }
//
//    public void setEnable(boolean enable) {
//        this.enable = enable;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//    // other fields, getters and setters are not shown
//}