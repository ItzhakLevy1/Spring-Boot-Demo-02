package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll(); // Returns a list of employees

    Employee findById(int theId); // Returns an employee by ID

    Employee save(Employee theEmployee); // Saves an employee (insert - if new, or update - if already exists)

    void deleteById(int theId); // Deletes an employee by ID
}
