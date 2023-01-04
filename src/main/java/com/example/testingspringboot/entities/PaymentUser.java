package com.example.testingspringboot.entities;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "payment_user")
public class PaymentUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String userName;
    @Column(name="email", unique=true)
    private String email;

    private String password;
    private  String phoneNumber;
    private long transactionId;


    @ElementCollection
    private List<String> courseId;

    private  Double totalPrice;
    public PaymentUser() {

    }


    public PaymentUser(Long id, String userName, String email, String password, String phoneNumber, long transactionId, List<String> coursId, Double totalPrice) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.transactionId = transactionId;
        this.courseId = courseId;
        this.totalPrice = totalPrice;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public List<String> getCourseId() {
        return courseId;
    }

    public void setCourseId(List<String> courseId) {
        this.courseId = courseId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
