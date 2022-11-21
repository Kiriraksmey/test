package com.example.testingspringboot.entities;

import javax.persistence.*;

@Entity
@Table(name="course")
public class course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private  String title;
    private String introduce;
    private  String image;
    private  String courseName;

    public course() {
    }

    public course(long id, String title, String introduce, String image, String courseName) {
        this.id = id;
        this.title = title;
        this.introduce = introduce;
        this.image = image;
        this.courseName = courseName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
