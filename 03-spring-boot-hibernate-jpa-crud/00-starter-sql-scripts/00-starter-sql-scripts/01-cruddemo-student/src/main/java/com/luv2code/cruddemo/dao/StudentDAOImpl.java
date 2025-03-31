package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;   // The EntityManager API is used to create and remove persistent entity instances, to find entities by their primary key, and to query over entities
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository // Indicates that this class is a DAO (Data Access Object) component = support for component scanning and spring support for exception translation
public class StudentDAOImpl implements StudentDAO{

    // Define a field for EntityManager
    private EntityManager entityManager;

    @Autowired  // Autowired is used for dependency constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override   // Save the student object to the database
    @Transactional  // Required since we are saving / updating / storing data to the database
    public void save(Student theStudent) {
        entityManager.persist(theStudent); // Persist the student object to the database
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id); // Find the student object by id
    }

    @Override
    public List<Student> findAll() {    // Find all student objects in the database

        // Create a query to get all students
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);    // "From Student" is the JPA class entity name, not the table name (JPQL)
        return theQuery.getResultList(); // Execute the query and get the result list
    }
}
