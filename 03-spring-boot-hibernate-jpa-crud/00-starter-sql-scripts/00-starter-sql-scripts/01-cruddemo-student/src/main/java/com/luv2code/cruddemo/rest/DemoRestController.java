package com.luv2code.cruddemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation indicates that this class is a REST controller
@RequestMapping("/test")    // This annotation maps HTTP requests to the specified URL path
public class DemoRestController {

    // Add code for the "/hello" endpoint
    // The full path would be: http://localhost:8080/test/hello

    @GetMapping("/hello") // This annotation maps HTTP GET requests to the "/hello" URL path)
    public String sayHello() { // This method returns a simple greeting message
        return "Hello World!"; // Return the greeting message
    }
}
