package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student); // Save the student object to the database

    Student findById(int id);   // Find the student object by id

    List<Student> findAll();    // Find all student objects in the database
}
