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
//public class Author {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String authorName;
//
//
//    private String email;
//
//
//    @OneToMany(mappedBy = "author")
//    private List<Book> bookList;
//
//
//
//}
