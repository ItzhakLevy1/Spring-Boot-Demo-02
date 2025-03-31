package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;   // The Jakarta Persistence API is a specification that provides a set of APIs for managing relational data in Java applications

@Entity // Map this class to a database table
@Table(name = "student")    // Map this class to the student table in the database
public class Student {

    // Define fields
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // let mySql handle Auto-increment on the primary key (given id)
    @Column(name = "id") // Map this field to the column in the database table
    private int id;

    @Column(name = "first_name")    // Map this field to the column in the database table
    private String firstName;

    @Column(name = "last_name")    // Map this field to the column in the database table
    private String lastName;

    @Column(name = "email")    // Map this field to the column in the database table
    private String email;

    // No-arg constructor
    public Student() {

    }

    // Constructor with parameters
    public  Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Define getter/setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Define toString() method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
