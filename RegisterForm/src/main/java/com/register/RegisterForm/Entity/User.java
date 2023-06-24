package com.register.RegisterForm.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="user")

public class User {

    @Id
    @Column(name="user_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name="user_name", length = 100)
    private String userName;

    @Column(name="surname", length = 100)
    private String surName;

    @Column(name="address", length = 50)
    private String address;

    @Column(name="phone_number", length = 25)
    private String phoneNumber;

    public User(int userId, String userName, String surName, String address, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.surName = surName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.userName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", surName='" + surName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}