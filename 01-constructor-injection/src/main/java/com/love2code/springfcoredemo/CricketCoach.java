package com.love2code.springfcoredemo;

import org.springframework.stereotype.Component;

@Component  // Marks this class as a Spring bean and makes it available for dependency injection
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :)";
    }

}
