package com.example.testingspringboot.entities;

import javax.persistence.*;

@Entity
@Table(name = "payment_user")
public class PaymentUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private  long phoneNumber;
    private long transactionId;
    private  long CourseId;
    private  Double TotalPrice;

    public PaymentUser(Long id, String userName, String email, long phoneNumber, long transactionId, long courseId, Double totalPrice) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.transactionId= transactionId;
        CourseId = courseId;
        TotalPrice = totalPrice;
    }

    public PaymentUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getCodePayment() {
        return transactionId;
    }

    public void setCodePayment(long codePayment) {
        this.transactionId = codePayment;
    }

    public long getCourseId() {
        return CourseId;
    }

    public void setCourseId(long courseId) {
        CourseId = courseId;
    }

    public Double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        TotalPrice = totalPrice;
    }
}
