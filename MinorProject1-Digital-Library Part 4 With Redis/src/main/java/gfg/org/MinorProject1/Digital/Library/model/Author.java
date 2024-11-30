package gfg.org.MinorProject1.Digital.Library.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String authorName;

    @Column(unique = true, nullable = false)
    private String email;


    @OneToMany(mappedBy = "author") 
    private List<Book> bookList;


}


//Attributes:
//id (int): Primary key, auto-generated.
//authorName (String): Name of the author.
//email (String): Unique and non-nullable email of the author.
//Relationships:
//bookList (List<Book>): One-to-many relationship with Book. One author can have multiple books.