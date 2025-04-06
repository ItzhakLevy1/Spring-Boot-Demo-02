package com.luv2code.cruddemo.rest;

public class StudentNotFoundException extends RuntimeException{

//    Generate constructors from the super class to be used in the REST controller

    public StudentNotFoundException(String message) {   // Constructor with message
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {  // Constructor with message and cause
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {  // Constructor with cause
        super(cause);
    }
}
