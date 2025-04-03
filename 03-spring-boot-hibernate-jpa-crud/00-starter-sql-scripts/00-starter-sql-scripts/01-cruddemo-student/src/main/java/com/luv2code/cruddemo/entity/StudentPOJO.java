package com.luv2code.cruddemo.entity;

public class StudentPOJO {

    private String firstName;	// The first name of the student
    private String lastName;	// The last name of the student

    public void studentPOJO() {	// No-arg constructor
    }

    public StudentPOJO(String firstName, String lastName) {	// Constructor with parameters
        this.firstName = firstName;
        this.lastName = lastName;
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
}
