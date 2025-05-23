package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student); // Save the student object to the database

    Student findById(int id);   // Find the student object by id

    List<Student> findAll();    // Find all student objects in the database

    List<Student> findByLastName(String theLastName); // Find all student objects by last name

    void update(Student student); // Update the student object in the database

    void delete(Integer id); // Delete the student object from the database by id

    int deleteAll(); // Delete all student objects from the database
}
