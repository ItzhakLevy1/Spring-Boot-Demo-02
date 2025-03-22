package com.love2code.springfcoredemo;

import org.springframework.stereotype.Component;

@Component  // Marks this class as a Spring bean and makes it available for dependency injection
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
