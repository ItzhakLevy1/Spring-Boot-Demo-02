package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service    // This annotation indicates that this class is a service component and tells Spring: “This class has business logic”
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;    // DAO layer to handle data access logic

    @Autowired  // Constructor injection
    public EmployeeServiceImpl (EmployeeDAO theEmployeeDAO) {

        this.employeeDAO = theEmployeeDAO;
    }

    @Override   // This method is implemented from the EmployeeService interface
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional  // Only required for methods that modify the database
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional  // Only required for methods that modify the database
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
