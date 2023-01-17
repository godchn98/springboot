package com.example.demo;

import java.sql.Date;

import javax.xml.crypto.Data;

import jakarta.validation.constraints.NotBlank;

public class User {
    
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;
    private String userName;
    private String email;
    private Date dateOfDate;


    public User(String firstName, String lastName, String userName, String email, Date dateOfDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateOfDate = dateOfDate;
    }

    public User() {
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfDate() {
        return this.dateOfDate;
    }

    public void setDateOfDate(Date dateOfDate) {
        this.dateOfDate = dateOfDate;
    }

}
