package com.example.testingspringboot.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "verifyToken")
public class VerifyToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="user_id")
    private  long userId;
    private  String token;
    private Date experyDate;
//@OneToOne(cascade =  {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
//@JoinColumn(name = "user_id",referencedColumnName = "id")
//private  User user;

    public VerifyToken() {
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public Date getExperyDate() {
        return experyDate;
    }
}
