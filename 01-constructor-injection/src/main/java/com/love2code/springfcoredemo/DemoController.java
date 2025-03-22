// Package declaration - this specifies the package in which this class is located.
package com.love2code.springfcoredemo;

// Import necessary Spring annotations and classes
import org.springframework.beans.factory.annotation.Autowired;   // Used for dependency injection.
import org.springframework.web.bind.annotation.GetMapping;     // Maps HTTP GET requests to specific handler methods.
import org.springframework.web.bind.annotation.RestController; // Marks the class as a REST controller.

// This annotation designates this class as a REST controller.
// It means this class will handle incoming web requests in a RESTful manner.
@RestController
public class DemoController {

    // A private field to hold the reference of the Coach object, following the principle of Dependency Injection.
    private Coach myCoach;

    @Autowired
    public void setCoach (Coach theCoach) { // Setter method for dependency injection.
        myCoach = theCoach;
    }

    // Maps the HTTP GET request with the URL "/dailyworkout" to this method.
    // When a user accesses the "/dailyworkout" endpoint, this method gets executed.
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        // Calls the 'getDailyWorkout' method of the injected Coach object and returns the result as a response.
        return myCoach.getDailyWorkout();
    }
}

