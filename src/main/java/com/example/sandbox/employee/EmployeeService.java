package com.example.sandbox.employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    void delete(int id);

    void deleteAll();
}
