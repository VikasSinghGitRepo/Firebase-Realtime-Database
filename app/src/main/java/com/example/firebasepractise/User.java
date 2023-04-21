package com.example.firebasepractise;


public class User {
    String userName;
    String firstName;
    String lastName;
    Date dob;

    public User() {
    }

    public User(String userName, String firstName, String lastName, String day, String month, String year) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        dob = new Date(day,month,year);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}