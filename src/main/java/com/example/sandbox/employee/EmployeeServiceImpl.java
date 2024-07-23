package com.example.sandbox.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee findById(long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public List<Employee> findByLastname(String lastname) {
        return employeeDAO.findByLastname(lastname);
    }

    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }

    @Override
    public int deleteAll() {
        return employeeDAO.deleteAll();
    }
}
