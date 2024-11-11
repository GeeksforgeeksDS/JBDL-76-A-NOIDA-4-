package gfg.test.SpringDataJPA.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



//    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID myId;

    @Column(name = "username")
    private String name;

    private int age;

    private String address;



}
