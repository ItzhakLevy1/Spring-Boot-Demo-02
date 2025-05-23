package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members")  // This annotation is used to expose the repository as a RESTful resource ( members instead of employees)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {  //
    // This interface extends JpaRepository, which provides CRUD operations for the Employee entity
    // The first parameter is the entity type (Employee), and the second parameter is the type of the entity's ID (Integer)
    // No need to implement any methods, JpaRepository provides all the necessary methods for CRUD operations
}


// http://localhost:8080/employee this endpoint will return a list of employees in JSON format,
// here is an example of a part of the JSON response you might get from this endpoint ( the additional meta-data is from the HATEOAS library generated by Spring Boot ):

/*
{
    "firstName": "Leslie",
    "lastName": "Andrews",
    "email": "leslie@luv2code.com",
    "_links": {
        "self": {
            "href": "http://localhost:8080/employee/1"
        },
        "employee": {
            "href": "http://localhost:8080/employee/1"
        }
    }
}
*/