package com.register.RegisterForm.DataTransferObject;

public class UserDto {

    private int userId;
    private String userName;
    private String surName;
    private String address;
    private String phoneNumber;

    public UserDto(int userId, String userName, String surName, String address, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.surName = surName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public UserDto() {

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

    public void setUserName(String userName) { this.userName = userName; }

    public String getSurName() { return surName; }

    public void setSurName(String surName) { this.surName = surName; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}