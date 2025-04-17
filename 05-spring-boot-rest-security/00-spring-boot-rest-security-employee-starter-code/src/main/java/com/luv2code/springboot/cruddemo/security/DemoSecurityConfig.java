package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {    // Create a bean of type InMemoryUserDetailsManager to manage user details in memory

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123") // {noop} means no operation, password encoder, just plain text
                .roles("EMPLOYEE")
                .build();   // Create that user details instance

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123") // {noop} means no operation, password encoder, just plain text
                .roles("EMPLOYEE", "MANAGER")
                .build();   // Create that user details instance

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123") // {noop} means no operation, password encoder, just plain text
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();   // Create that user details instance

        return new InMemoryUserDetailsManager(john, mary, susan); // Create the in-memory user details manager with the users
    }
}

/* Since we defined our users here,Spring Boot will NOT use the user/password from the application.properties file */