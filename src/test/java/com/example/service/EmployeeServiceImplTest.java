package com.example.service;


import com.example.controller.EmployeeController;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testSaveEmployee(){
        Employee emp=new Employee();
        emp.setName("Aakash");
        emp.setRole("Developer");

        when(employeeRepository.save(any())).thenReturn(emp);

        Employee result= employeeService.saveEmployee(emp);

        assertEquals("Aakash",result.getName());
        assertEquals("Developer",result.getRole());

    }

}
