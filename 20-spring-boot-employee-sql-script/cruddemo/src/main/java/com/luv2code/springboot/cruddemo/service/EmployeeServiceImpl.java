package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service    // This annotation indicates that this class is a service component and tells Spring: “This class has business logic”
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;    // Use the EmployeeRepository interface to access the database instead of the EmployeeDAO interface

    @Autowired  // Constructor injection
    public EmployeeServiceImpl (EmployeeRepository theEmployeeRepository) { // Inject the EmployeeRepository using constructor injection

        this.employeeRepository = theEmployeeRepository;
    }

    @Override   // This method is implemented from the EmployeeService interface
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId); // Optional is a container object which may or may not contain a non-null value

        Employee theEmployee = null;

        if (result.isPresent()) { // Check if the employee with the given ID exists
            theEmployee = result.get(); // Get the employee object from the Optional
        } else {
            throw new RuntimeException("Did not find employee id - " + theId); // If not found, throw an exception
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
