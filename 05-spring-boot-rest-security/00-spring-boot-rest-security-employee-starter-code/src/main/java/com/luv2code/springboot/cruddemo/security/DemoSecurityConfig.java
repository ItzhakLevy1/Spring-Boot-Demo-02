package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // Create a bean of type SecurityFilterChain to configure security for the application

        http.authorizeHttpRequests(configurer ->    // Configure the HTTP security
                        configurer
                                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE") // Allow access to /api/employees only to users with role EMPLOYEE
                                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE") // Allow access to /api/employees/** only to users with role EMPLOYEE
                                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")  // Allow access to /api/employees only to users with role MANAGER
                                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")  // Allow access to /api/employees only to users with role MANAGER
                                .requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER")  // Allow access to /api/employees only to users with role MANAGER
                                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")  // Allow access to /api/employees/** only to users with role ADMIN
        );
        // Use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // Disable Cross-Site Request Forgery ( CSRF ) protection, in a REST API, CSRF protection is not needed for stateless APIs that use POST, PUT, DELETE, PATCH methods
        http.csrf(csrf -> csrf.disable());

        return http.build(); // Build the security filter chain
    }
}

/* Since we defined our users here,Spring Boot will NOT use the user/password from the application.properties file */