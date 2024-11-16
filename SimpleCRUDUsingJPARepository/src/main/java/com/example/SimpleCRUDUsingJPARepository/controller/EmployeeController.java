package com.example.SimpleCRUDUsingJPARepository.controller;

import com.example.SimpleCRUDUsingJPARepository.dto.CreateEmployeeRequest;
import com.example.SimpleCRUDUsingJPARepository.model.Employee;
import com.example.SimpleCRUDUsingJPARepository.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return ResponseEntity.ok(employeeService.createEmployee(createEmployeeRequest));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, createEmployeeRequest));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    @GetMapping("/getAgeGreaterThanOrEqualTo/{age}")
    public ResponseEntity<List<Employee>> getAgeGreaterThanOrEqualTo(@PathVariable("age") int age) {
        return ResponseEntity.ok(employeeService.getAgeGreaterThanOrEqualTo(age));
    }


    @GetMapping("getByNameAndEmail/{name}/{email}")
    public ResponseEntity<Employee> getByNameAndEmail(@PathVariable("name") String name, @PathVariable("email") String email) {
        return ResponseEntity.ok(employeeService.getByNameAndEmail(name, email));
    }




}
