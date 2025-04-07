package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository // Indicates that this class is a Data Access Object (DAO) and is responsible for interacting with the database
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // Define the fields for entity manager ( JPA ) is used to interact with the database
    private EntityManager entityManager;

    // Define the constructor injection for entity manager
    public EmployeeDAOJpaImpl(EntityManager entityManager) {    // The EntityManager is automatically created and injected by Spring
        this.entityManager = entityManager;
    }

    @Override   // This method is implemented from the EmployeeDAO interface
    public List<Employee> findAll() {

        // Create a query :
        // TypedQuery<Student> - JPQL (Java Persistence Query Language - works with Java entity classes instead of actual database tables) query to select all employees
        // theQuery - the variable name that holds the query result
        // entityManager.createQuery(...) - entityManager is an instance of EntityManager, .createQuery(...) is a method of EntityManager that creates a new query to retrieve data from the database
        // "FROM Employee" - tells JPA to select all records from the Student entity
        // Employee.class - specifies the expected return type of the query (in this case, Employee)
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // Execute the query and get the result list
        List<Employee> employees = theQuery.getResultList();

        // Return the results
        return employees;
    }
}
