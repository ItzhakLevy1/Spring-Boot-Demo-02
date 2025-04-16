package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {  //
    // This interface extends JpaRepository, which provides CRUD operations for the Employee entity
    // The first parameter is the entity type (Employee), and the second parameter is the type of the entity's ID (Integer)
    // No need to implement any methods, JpaRepository provides all the necessary methods for CRUD operations
}
