package com.love2code.springfcoredemo;

import org.springframework.stereotype.Component;

@Component  // Marks this class as a Spring bean and makes it available for dependency injection
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }
}
