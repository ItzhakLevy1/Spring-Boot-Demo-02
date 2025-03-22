package com.love2code.springfcoredemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component  // Marks this class as a Spring bean and makes it available for dependency injection
@Primary    // Sets this class as the primary bean when there are multiple implementations of the same interface
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
