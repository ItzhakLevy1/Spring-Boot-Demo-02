package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.StudentPOJO;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        // Check the studentId against the size of the list
        if ((studentId >= theStudents.size()) || (studentId < 0)) { // If the studentId is out of bounds, meaning its index exceeds the size of the list or is less than 0
            throw new StudentPOJONotFoundException("Student id not found - " + studentId); // Throw a custom exception
        }

        return theStudents.get(studentId); // Return the student at the specified index if there are no issues
    }

    // Add an exception handler using @ExceptionHandler
    // This method will handle the StudentPOJONotFoundException
    // http://localhost:8080/api/students/9999 - this will throw an exception (anything greater than 2 or less than 0)

    @ExceptionHandler // Indicates that this method will handle exceptions
    public ResponseEntity<StudentPOJOErrorResponse> handleException(StudentPOJONotFoundException exc) { // <StudentPOJOErrorResponse> is the type of the response body, (StudentPOJONotFoundException exc) is the exception to be handled

        // Create a StudentPOJOErrorResponse object
        StudentPOJOErrorResponse error = new StudentPOJOErrorResponse();    // Create a new error response object

        // Set the error details
        error.setStatus(HttpStatus.NOT_FOUND.value()); // Set the status to NOT_FOUND (404)
        error.setMessage(exc.getMessage()); // Set the message from the exception message
        error.setTimeStamp(System.currentTimeMillis()); // Set the current timestamp

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // Return the error response body with a NOT_FOUND status
    }

    // Add another exception handler for any other exceptions ( such ass String instead of integer as the studentId in the url )
    // http://localhost:8080/api/students/asdf - this will throw an exception

    @ExceptionHandler // Indicates that this method will handle exceptions
    public ResponseEntity<StudentPOJOErrorResponse> handleException(Exception exc) { // <StudentPOJOErrorResponse> is the type of the response body, (Exception exc) is the exception to be handled

        // Create a StudentPOJOErrorResponse object
        StudentPOJOErrorResponse error = new StudentPOJOErrorResponse();    // Create a new error response object

        // Set the error details
        error.setStatus(HttpStatus.BAD_REQUEST.value()); // Set the status to BAD_REQUEST (400)
        error.setMessage(exc.getMessage()); // Set the message from the exception message
        error.setTimeStamp(System.currentTimeMillis()); // Set the current timestamp

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); // Return the error response body with a BAD_REQUEST status
    }
}
