package com.example.SimpleCRUDUsingJPARepository.dto;

import com.example.SimpleCRUDUsingJPARepository.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployeeResponse {

    private int id;

    private String name;

    private String email;

    private int age;

    private UUID departmentId;

    @CreationTimestamp
    private Date createdOn;

//    @UpdateTimestamp
//    private Date updatedOn;


    public Employee fromEmployee(){
        return Employee.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email)
                .age(this.age)
                .departmentId(this.departmentId)

                .build();
    }


}
