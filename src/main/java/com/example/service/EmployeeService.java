package com.example.service;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee emp);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    void deleteEmployee(Long id);
}
