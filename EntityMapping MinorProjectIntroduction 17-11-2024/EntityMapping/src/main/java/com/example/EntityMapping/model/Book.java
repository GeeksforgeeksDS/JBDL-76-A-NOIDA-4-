//package com.example.EntityMapping.model;
//
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Entity
//@Data
//public class Book {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//
//
//    private String title;
//
//    private int pages;
//
//    private int cost;
//
//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    private Author author;
//
//}
