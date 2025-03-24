package com.love2code.springfcoredemo;

public class SwimCoach implements Coach{

    // Define a constructor for dependency injection into the DemoController
    public SwimCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
