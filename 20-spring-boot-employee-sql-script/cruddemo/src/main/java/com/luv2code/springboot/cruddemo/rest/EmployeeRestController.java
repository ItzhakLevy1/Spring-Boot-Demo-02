package com.luv2code.springboot.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController // This annotation indicates that this class is a REST controller and tells Spring: “This class handles HTTP requests and responses”
@RequestMapping("/api") // Base URL for all endpoints in this controller
public class EmployeeRestController {

    private EmployeeService employeeService; // Service layer to handle business logic
    private ObjectMapper objectMapper; // ObjectMapper to convert Java objects to JSON and vice versa

    // Inject the Employee DAO using constructor injection
    @Autowired  // Constructor injection
    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper) {
        this.employeeService = theEmployeeService;
        this.objectMapper = theObjectMapper;
    }

    // Expose the "/employees" endpoint to get all employees
    // The whole URL will be http://localhost:8080/api/employees
    @GetMapping("/employees")   // This annotation maps HTTP GET requests to the findAll() method
    public List<Employee> findAll() {   // List<Employee> - The method will return a list of Employee objects : [Employee1, Employee2, Employee3, ...]
        return employeeService.findAll(); // Call the DAO method to get all employees
    }

    // Add mapping for GET /employees/{employeeId}, The whole URL will be http://localhost:8080/api/employees/{employeeId}
    @GetMapping("/employees/{employeeId}") // This annotation maps HTTP GET requests to the findById() method
    public Employee getEmployee(@PathVariable int employeeId) { // @PathVariable -  tells Spring to bind the URL path variable ( employeeId ) to the method parameter
        Employee theEmployee = employeeService.findById(employeeId); // Call the DAO method to get the employee by ID

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId); // If the employee is not found, throw an exception
        }

        return theEmployee; // Return the employee object
    }


    // Add mapping for POST /employees - add a new employee, the whole URL will be http://localhost:8080/api/employees

    /*
    The post request will contain the employee object in JSON format :
    {"firstName" : "Hector","lastName": "Perez","email" : "hector@luv2code.com"}
    */
    @PostMapping("/employees") // This annotation maps HTTP POST requests to the save() method
    public Employee addEmployee(@RequestBody Employee theEmployee) { // @RequestBody - This annotation binds the HTTP request body ( JSON ) to the method parameter

        // Just in case they pass an ID in JSON ... set id to 0
        // This is to force a save of new item ... instead of update

        theEmployee.setId(0); // Set the ID to 0 to indicate a new employee

        Employee dbEmployee = employeeService.save(theEmployee); // Call the DAO method to save the employee

        return dbEmployee; // Return the saved employee object
    }


    // Add mapping for PUT /employees - update an existing employee, the whole URL will be http://localhost:8080/api/employees/{employeeId}

    /*
    The PUT request will contain the employee object in JSON format :
    {"id": 1,"firstName" : "Timothy","lastName": "Patterson","email" : "tim@luv2code.com"}
    */
    @PutMapping("/employees") // This annotation maps HTTP PUT requests to the update() method
    public Employee updateEmployee(@RequestBody Employee theEmployee) { // @RequestBody - This annotation binds the HTTP request body ( JSON ) to the method parameter

        Employee dbEmployee = employeeService.save(theEmployee); // Call the DAO method to save the employee

        return dbEmployee; // Return the updated employee object
    }


    // Add mapping for PATCH /employees - partially update an existing employee, the whole URL will be http://localhost:8080/api/employees/{employeeId}
    @PatchMapping("/employees/{employeeId}") // This annotation maps HTTP PATCH requests to the partialUpdate() method
    public Employee patchEmployee(@PathVariable int employeeId, // @PathVariable -  tells Spring to bind the URL path variable ( employeeId ) to the method parameter
                                  @RequestBody Map<String, Object> patchPayload) {  // JSON data is passed in as a Map of key - value pairs

        Employee tempEmployee = employeeService.findById(employeeId); // Call the DAO method to get the employee by ID

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId); // If the employee is not found, throw an exception
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id is not allowed in request body - " + employeeId); // If the employee ID is in the payload, throw an exception since we don't want to allow it to be updated
        }

        Employee patchedEmployee = apply(patchPayload, tempEmployee); // Apply the patch to the employee object ( Only in memory, not in the database yet )

        Employee dbEmployee = employeeService.save(patchedEmployee); // Call the DAO method to save the employee ( This will update the employee in the database )

        return dbEmployee; // Return the updated employee object
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {

        // 1.Convert employee object to JSON object node ( string )
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        // 2.Convert the patch payload to JSON object node ( string )
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // 3.Merge the patch node into the employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class); // Convert the merged node back to an Employee object
    }

}
