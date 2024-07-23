package com.example.sandbox.employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee findById(long id);

    List<Employee> findAll();

    List<Employee> findByLastname(String lastname);

    void delete(int id);

    int deleteAll();
}
