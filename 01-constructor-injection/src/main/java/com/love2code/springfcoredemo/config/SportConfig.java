package com.love2code.springfcoredemo.config;

import com.love2code.springfcoredemo.Coach;
import com.love2code.springfcoredemo.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // Define a bean method to configure the bean
    // This will be injected into the DemoController
    @Bean("aquatic")    // This is a custom bean id, otherwise it would be swimCoach by default
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
