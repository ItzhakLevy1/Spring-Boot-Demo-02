package com.luv2code.springboot.cruddemo.rest;


import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api") // Base URL for all endpoints in this controller
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    // Inject the Employee DAO using constructor injection
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    // Expose the "/employees" endpoint to get all employees
    // The whole URL will be http://localhost:8080/api/employees
    @GetMapping("/employees")
    public List<Employee> findAll() {   // List<Employee> - The method will return a list of Employee objects : [Employee1, Employee2, Employee3, ...]
        return employeeDAO.findAll(); // Call the DAO method to get all employees
    }

}
