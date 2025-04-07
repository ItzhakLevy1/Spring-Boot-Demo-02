package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service    // This annotation indicates that this class is a service component and tells Spring: “This class has business logic”
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired  // Constructor injection
    public EmployeeServiceImpl (EmployeeDAO theEmployeeDAO) {
        this.employeeDAO = theEmployeeDAO;
    }

    @Override   // This method is implemented from the EmployeeService interface
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
