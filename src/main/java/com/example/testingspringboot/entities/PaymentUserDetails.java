package com.example.testingspringboot.entities;

import javax.persistence.*;

@Entity
@Table(name = "payment_user_details")
public class PaymentUserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long courserId;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourserId() {
        return courserId;
    }

    public void setCourserId(Long courserId) {
        this.courserId = courserId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
