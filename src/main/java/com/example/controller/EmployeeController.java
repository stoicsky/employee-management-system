package com.example.controller;


import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/employees")  // base url
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> create( @RequestBody Employee emp){
        System.out.println(">> inside create()- Employee:"+emp.getName()+", "+emp.getRole() );
        return ResponseEntity.ok(employeeService.saveEmployee(emp));
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee>getOne(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return  ResponseEntity.ok().build();
    }

    //update api
    @PutMapping("/{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmp){
        Employee emp=employeeService.updateEmployee(id,updatedEmp);
        return ResponseEntity.ok(emp);
    }



}
