package com.example.sandbox.employee;

import com.example.sandbox.student.Student;

import java.util.List;

public interface EmployeeDAO {
    Employee save(Employee employee);

    Employee findById(long id);

    List<Employee> findAll();

    List<Employee> findByLastname(String lastname);

    void delete(int id);

    int deleteAll();
}
