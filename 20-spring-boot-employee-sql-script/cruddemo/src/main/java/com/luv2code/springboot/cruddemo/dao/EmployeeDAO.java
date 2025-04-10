package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import java.util.List;

// This interface defines the data access methods for Employee entity to be implemented by the DAO service layer
public interface EmployeeDAO {

    List<Employee> findAll(); // Returns a list of employees

    Employee findById(int theId); // Returns an employee by ID

    Employee save(Employee theEmployee); // Saves an employee (insert - if new, or update - if already exists)

    void deleteById(int theId); // Deletes an employee by ID
}
