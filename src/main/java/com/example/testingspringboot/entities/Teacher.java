package com.example.testingspringboot.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teacherName;
    private String gender;
    private Integer age;

    @Column(name="address", length=500 )
    private String address;
    private String email;
    private String maritalStatus;
    private Date createDate;
    private Date updateDate;
    private String user;




    public Teacher() {
    }

    public Teacher(Long id, String teacherName, String gender, Integer age, String address, String email, String maritalStatus, Date createDate, Date updateDate, String user) {
        this.id = id;
        this.teacherName = teacherName;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.email = email;
        this.maritalStatus = maritalStatus;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
