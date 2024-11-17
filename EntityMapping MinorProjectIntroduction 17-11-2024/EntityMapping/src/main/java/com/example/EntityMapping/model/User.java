//package com.example.EntityMapping.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//public class User {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String name;
//    private String email;
//
//
//    private String password;
//
//
//    @OneToOne
//    @JoinColumn(name = "profile_id")
//    private Profile profile;
//
//}
