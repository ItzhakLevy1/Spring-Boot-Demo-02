package com.luv2code.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   // This annotation is used to handle exceptions globally across all controllers
public class StudentRestExceptionHandler {

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
