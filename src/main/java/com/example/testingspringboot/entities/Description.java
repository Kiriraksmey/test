package com.example.testingspringboot.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="descriptions")
public class Description {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private  String description;
    private Date createDate;
    private  Date updateDate;
    private String user;




    public Description() {
    }

    public Description(long id, String description, Date createDate, Date updateDate, String user) {
        this.id = id;
        this.description = description;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
