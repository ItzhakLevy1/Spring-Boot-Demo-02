package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;	// CommandLineRunner is a Spring Boot interface that can be used to execute code after the application has started
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {	// Inject the StudentDAO bean
		return runner -> {	// Lambda expression for the CommandLineRunner interface
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// Create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);	// Call the save method from the StudentDAO interface

		// Display the id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
