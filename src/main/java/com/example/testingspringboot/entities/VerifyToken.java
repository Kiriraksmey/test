package com.example.testingspringboot.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "verifyToken")
public class VerifyToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  long userId;
    private  String token;
    private Date experyDate;
@OneToOne(cascade =  {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
@JoinColumn(name = "user_id",referencedColumnName = "id")
private  User user;

    public VerifyToken(String token, User user) {
    }

    public VerifyToken(long id, long userId, String token, Date experyDate) {
        this.id = id;
        this.userId = userId;
        this.token = token;
        this.experyDate = experyDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExperyDate() {
        return experyDate;
    }

    public void setExperyDate(Date experyDate) {
        this.experyDate = experyDate;
    }
}
