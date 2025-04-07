package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;


@Entity // An entity class represents an employee to be mapped to a database table
@Table(name="employee")  // Specifies the table name in the database

public class Employee {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // let mySql handle Auto-increment on the primary key (given id)
    @Column(name="id") // Specifies the column name in the database
    private int id;

    @Column(name="first_name") // Specifies the column name in the database
    private String firstName;

    @Column(name="last_name") // Specifies the column name in the database
    private String lastName;

    @Column(name="email") // Specifies the column name in the database
    private String email;

    // No-arg constructor
    public Employee() {
    }

    // Constructor with parameters
    public Employee(String firstName, String lastName, String email) {  // No need to include id in the constructor since it is auto-generated
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
