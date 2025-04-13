package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController // This annotation indicates that this class is a REST controller and tells Spring: “This class handles HTTP requests and responses”
@RequestMapping("/api") // Base URL for all endpoints in this controller
public class EmployeeRestController {

    private EmployeeService employeeService; // Service layer to handle business logic

    // Inject the Employee DAO using constructor injection
    @Autowired  // Constructor injection
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    // Expose the "/employees" endpoint to get all employees
    // The whole URL will be http://localhost:8080/api/employees
    @GetMapping("/employees")   // This annotation maps HTTP GET requests to the findAll() method
    public List<Employee> findAll() {   // List<Employee> - The method will return a list of Employee objects : [Employee1, Employee2, Employee3, ...]
        return employeeService.findAll(); // Call the DAO method to get all employees
    }

    // Add mapping for GET /employees/{employeeId}, The whole URL will be http://localhost:8080/api/employees/{employeeId}
    @GetMapping("/employees/{employeeId}") // This annotation maps HTTP GET requests to the findById() method
    public Employee getEmployee(@PathVariable int employeeId) { // @PathVariable - This annotation binds the method parameter to the URI template variable
        Employee theEmployee = employeeService.findById(employeeId); // Call the DAO method to get the employee by ID

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId); // If the employee is not found, throw an exception
        }

        return theEmployee; // Return the employee object
    }

}
