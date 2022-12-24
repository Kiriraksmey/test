package com.example.testingspringboot.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "image")
    private String image;
    @Column(name="description", length=1000 )
    private String description;
    @Column(name="limit_day")
    private int limitDay;
    @Column(name="price")
    private double price;
    @Column(name="create_date")
    private Date createDate;
    @Column(name="update_date")
    private Date updateDate;
    @Column(name="user")
    private String user;
    @Column(name="status")
    private  boolean status;
    @Column(name="teacher_id")
    private long teacherId;
    @Column(name="description_id")
    private long descriptionId;


   //  Relationship =====================

//        @OneToMany
//        @JoinColumn(name = "course_id") // we need to duplicate the physical information
//        private Set<CourseDetail> courseDetails;
//
//        @OneToMany
//        @JoinColumn(name = "teacher_id") // we need to duplicate the physical information
//        private Set<Teacher> teachers;
//
//       @OneToMany
//       @JoinColumn(name = "description_id") // we need to duplicate the physical information
//      private Set<Description> descriptions;

    public Course() {
    }


    public Course(long id, String courseName, String image, String description, int limitDay, double price, Date createDate, Date updateDate, String user, boolean status, long teacherId, long descriptionId, Set<CourseDetail> courseDetails, Set<Teacher> teachers, Set<Description> descriptions) {
        this.id = id;
        this.courseName = courseName;
        this.image = image;
        this.description = description;
        this.limitDay = limitDay;
        this.price = price;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.user = user;
        this.status = status;
        this.teacherId = teacherId;
        this.descriptionId = descriptionId;
//        this.courseDetails = courseDetails;
//        this.teachers = teachers;
//        this.descriptions = descriptions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLimitDay() {
        return limitDay;
    }

    public void setLimitDay(int limitDay) {
        this.limitDay = limitDay;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(long descriptionId) {
        this.descriptionId = descriptionId;
    }

//    public Set<CourseDetail> getCourseDetails() {
//        return courseDetails;
//    }
//
//    public void setCourseDetails(Set<CourseDetail> courseDetails) {
//        this.courseDetails = courseDetails;
//    }
//
//    public Set<Teacher> getTeachers() {
//        return teachers;
//    }
//
//    public void setTeachers(Set<Teacher> teachers) {
//        this.teachers = teachers;
//    }
//
//    public Set<Description> getDescriptions() {
//        return descriptions;
//    }
//
//    public void setDescriptions(Set<Description> descriptions) {
//        this.descriptions = descriptions;
//    }
}
