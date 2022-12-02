package com.example.testingspringboot.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String name;
    private  String link;
    private  String description;
    private Date createDate;
    private  Date updateDate;
    private  String user;
    private  Boolean defualt;

    @Column(name = "course_detail_id")
    private Long courseDetailId;

//    @ManyToOne
//    @JoinColumn(name="course_detail_id", nullable=false)
//    private CourseDetail detail;

//    public CourseDetail getDetail() {
//        return detail;
//    }
//
//    public void setDetail(CourseDetail detail) {
//        this.detail = detail;
//    }

    public Video() {
    }

    public Video(long id, String name, String link, String description, Date createDate, Date updateDate, String user, Boolean defualt, Long courseDetailId) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.user = user;
        this.defualt = defualt;
        this.courseDetailId = courseDetailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getCourseDetailId() {
        return courseDetailId;
    }

    public void setCourseDetailId(Long courseDetailId) {
        this.courseDetailId = courseDetailId;
    }

    public Boolean getDefualt() {
        return defualt;
    }

    public void setDefualt(Boolean defualt) {
        this.defualt = defualt;
    }
}
