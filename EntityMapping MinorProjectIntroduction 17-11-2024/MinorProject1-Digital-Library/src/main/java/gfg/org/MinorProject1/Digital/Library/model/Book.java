package gfg.org.MinorProject1.Digital.Library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookName;

    private int pages;

    private int cost;

    private String producer;

    private String bookNo;

    @Enumerated(value = EnumType.STRING)
    private BookType bookType;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(mappedBy = "book")
    private List<Txn> txnList;





}


//Attributes:
//id (int): Primary key, auto-generated.
//bookName (String): Name of the book.
//bookNo (String): Unique identifier for the book.
//bookType (BookType): Enum to categorize the book type (EDUCATIONAL, TECHNICAL).
//pages (int): Number of pages in the book.
//cost (int): Cost of the book.

//Relationships:
//author (Author): Many-to-one relationship with Author.
//student (Student): Many-to-one relationship with Student.
//txn (List<Txn>): One-to-many relationship with Txn for book transactions.