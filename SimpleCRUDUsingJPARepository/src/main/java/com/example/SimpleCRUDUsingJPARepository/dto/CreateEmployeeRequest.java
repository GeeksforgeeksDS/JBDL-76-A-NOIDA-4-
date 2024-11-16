package com.example.SimpleCRUDUsingJPARepository.dto;

import com.example.SimpleCRUDUsingJPARepository.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployeeRequest {


    private String name;

    private String email;

    private int age;

    private String departmentId;

    public Employee toEmployee() {
        return Employee.builder()
                .name(this.name)
                .email(this.email)
                .age(this.age)
                .departmentId(UUID.randomUUID())
                .build();
    }

    //Employee employee = new Employee(this.name, this.email);


}
