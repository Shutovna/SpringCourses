package com.example.sandbox.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee " + id + " not found");
        }
        return employee;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }


    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee " + id + " not found");
        }
        employeeService.delete(id);
    }
}