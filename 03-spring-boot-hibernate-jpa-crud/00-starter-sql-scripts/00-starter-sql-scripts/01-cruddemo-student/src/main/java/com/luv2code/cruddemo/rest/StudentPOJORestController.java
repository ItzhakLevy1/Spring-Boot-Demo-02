package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.Student;
import com.luv2code.cruddemo.entity.StudentPOJO;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // This annotation indicates that this class is a REST controller
@RequestMapping("/api") // This annotation maps HTTP requests to the specified URL path
public class StudentPOJORestController {

    private List<StudentPOJO> theStudents; // This theStudents variable holds the list of students

    @PostConstruct  // Indicates that the method should run automatically after the bean is created and initialized, but before it is used
    public void loadData() {

        theStudents = new ArrayList<>(); // Create a new list of students

        theStudents.add(new StudentPOJO("Poornima", "Patel")); // Add a new student to the list
        theStudents.add(new StudentPOJO("Mario", "Rossi")); // Add a new student to the list
        theStudents.add(new StudentPOJO("Mary", "Smith")); // Add a new student to the list
    }

    @GetMapping("/students") // This annotation maps HTTP GET requests to the "/students" endpoint
    public List<StudentPOJO> getStudents() { // This method returns a list of students ( POJO stands for Plain Old Java Object )
        return theStudents;
    }

    // An endpoint to get a student at index - "/students/{studentId}"
    // The full path would be: http://localhost:8080/api/students/0
    @GetMapping("/students/{studentId}")
    public StudentPOJO getStudent(@PathVariable int studentId) { // This method returns a student at the specified index, @PathVariable is used to extract the value from the URL
        return theStudents.get(studentId); // Return the student at the specified index
    }
}
