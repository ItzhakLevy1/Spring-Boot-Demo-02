package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.StudentPOJO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // This annotation indicates that this class is a REST controller
@RequestMapping("/api") // This annotation maps HTTP requests to the specified URL path
public class StudentPOJORestController {


    @GetMapping("/students") // This annotation maps HTTP GET requests to the "/students" endpoint
    public List<StudentPOJO> getStudents() { // This method returns a list of students ( POJO stands for Plain Old Java Object )

        List<StudentPOJO> theStudents = new ArrayList<>(); // Create a new list of students

        theStudents.add(new StudentPOJO("Poorima", "Patel")); // Add a new student to the list
        theStudents.add(new StudentPOJO("Mario", "Rossi")); // Add a new student to the list
        theStudents.add(new StudentPOJO("Mary", "Smith")); // Add a new student to the list

        return theStudents;
    }
}
