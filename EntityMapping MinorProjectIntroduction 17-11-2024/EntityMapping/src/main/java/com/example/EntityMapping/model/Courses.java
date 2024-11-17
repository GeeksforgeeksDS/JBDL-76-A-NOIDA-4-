package com.example.EntityMapping.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String courseName;


    @ManyToMany(mappedBy = "courses")
    private List<Student> student;




}
