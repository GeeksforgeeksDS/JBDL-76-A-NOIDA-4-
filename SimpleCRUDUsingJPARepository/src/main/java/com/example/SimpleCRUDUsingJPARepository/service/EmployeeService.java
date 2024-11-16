package com.example.SimpleCRUDUsingJPARepository.service;

import com.example.SimpleCRUDUsingJPARepository.dto.CreateEmployeeRequest;
import com.example.SimpleCRUDUsingJPARepository.model.Employee;
import com.example.SimpleCRUDUsingJPARepository.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

   @Transactional
    public Employee createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = employeeRepository.save(createEmployeeRequest.toEmployee());
        int i = 0;
        int j= 3;
        int result = j/i;

         return employee;
    }


    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }


    public Employee updateEmployee(int id, CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = employeeRepository.findById(id).get();

        employee.setName(createEmployeeRequest.getName());
        employee.setEmail(createEmployeeRequest.getEmail());
        employee.setAge(createEmployeeRequest.getAge());
        return employeeRepository.save(employee);

    }


    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully";
    }

    public List<Employee> getAgeGreaterThanOrEqualTo(int age) {
        return employeeRepository.findByAgeGreaterThanEqual(age);
    }

    public Employee getByNameAndEmail(String name, String email) {
        return employeeRepository.getByNameAndEmail(name, email);
    }
}
