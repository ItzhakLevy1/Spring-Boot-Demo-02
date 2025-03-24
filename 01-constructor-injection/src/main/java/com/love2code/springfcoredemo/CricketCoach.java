package com.love2code.springfcoredemo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  // Marks this class as a Spring bean and makes it available for dependency injection
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Prototype scope creates a new instance of the cricketCoach every time and therefor will return false when comparing the two beans in the DemoController
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :)";
    }

}
