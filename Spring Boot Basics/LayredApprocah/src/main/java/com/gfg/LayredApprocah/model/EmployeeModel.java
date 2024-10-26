package com.gfg.LayredApprocah.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeModel {

    private int id;
    private String name;
    private String address;

    private LocalDate CreatedOn;
    private LocalDate UpdatedOn;
}
