package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;	// The StudentDAO interface is used to define the methods for accessing the student data
import com.luv2code.cruddemo.entity.Student;	// The Student class is used to represent the student entity in the database
import org.springframework.boot.CommandLineRunner;	// CommandLineRunner is a Spring Boot interface that can be used to execute code after the application has started
import org.springframework.boot.SpringApplication;	// SpringApplication is a class that provides static methods to bootstrap a Spring application
import org.springframework.boot.autoconfigure.SpringBootApplication;	// SpringBootApplication is a convenience annotation that adds all of the following: @Configuration, @EnableAutoConfiguration, and @ComponentScan
import org.springframework.context.annotation.Bean;	// Bean is used to indicate that a method produces a bean to be managed by the Spring container

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {	// Inject the StudentDAO bean
		return runner -> {	// Lambda expression for the CommandLineRunner interface

			//readStudent(studentDAO);	// Call the readStudent method to create and read a student
			//createMultipleStudents(studentDAO);
			//queryForStudents(studentDAO);	// Call the queryStudent method to read a student

			//queryForStudentsByLastName(studentDAO);	// Call the queryForStudentsByLastName method to read a student by last name
			//updateStudent(studentDAO);	// Call the updateStudent method to update a student
			deleteStudent(studentDAO);	// Call the deleteStudent method to delete a student
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;	// Set the student id to 3
		System.out.println("Deleting student with id: " + studentId);	// Print the student id
		studentDAO.delete(studentId);	// Call the delete method from the StudentDAO interface
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve a student based on the id: primary key
		int studentId = 1;	// Set the student id to 1
		System.out.println("Getting student with the id of : " + studentId);	// Print the student id
		Student myStudent = studentDAO.findById(studentId);	// Call the findById method from the StudentDAO interface

		// Change the first name to "Scooby"
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		// Update the student
		studentDAO.update(myStudent);

		// Display the updated student
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// Get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");	// Call the findByLastName method from the StudentDAO interface

		// Display the list of students
		for (Student tempStudent : theStudents) {	// Loop through the list of students
			System.out.println(tempStudent);	// Print each student
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// Get a list of students
		List<Student> theStudents = studentDAO.findAll();	// Call the findAll method from the StudentDAO interface

		// Display the list of students
		for (Student tempStudent : theStudents) {	// Loop through the list of students
			System.out.println(tempStudent);	// Print each student
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// Create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		// Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);	// Call the save method from the StudentDAO interface

		// Display the id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// Retrieve the student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);	// Call the findById method from the StudentDAO interface

		// Display the student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create multiple student objects
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// Save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
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
