package com.luv2code.cruddemo.rest;

public class StudentPOJONotFoundException extends RuntimeException{

//    Generate constructors from the super class to be used in the REST controller

    public StudentPOJONotFoundException(String message) {   // Constructor with message
        super(message);
    }

    public StudentPOJONotFoundException(String message, Throwable cause) {  // Constructor with message and cause
        super(message, cause);
    }

    public StudentPOJONotFoundException(Throwable cause) {  // Constructor with cause
        super(cause);
    }
}
