package com.example.incomingData.userPost.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;
    private String username;
    private String password;
    private double salary;
    private String designation;


    @CreationTimestamp
    private Timestamp createDate;
    public Users(){

    }

    public Users(String username, String password, double salary, String designation) {
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.designation = designation;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", uname='" + username + '\'' +
                ", upass='" + password + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", createDate=" + createDate +

                '}';
    }
}
