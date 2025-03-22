package com.love2code.springfcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  // Marks this class as a Spring bean and makes it available for dependency injection
public class CricketCoach implements Coach{

    @Autowired
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes...!";
    }

}
