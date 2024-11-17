package gfg.org.MinorProject1.Digital.Library.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String address;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "student")
    private List<Book> books;

    @OneToMany(mappedBy = "student")
    private List<Txn> txn;





}



//Attributes:
//id (int): Primary key, auto-generated.
//name (String): Student's name.
//email (String): Email address of the student.
//address (String): Address of the student.
//createdOn (Date): Timestamp when the student entity was created.
//updatedOn (Date): Timestamp for the last update.
//Relationships:
//txn (List<Txn>): One-to-many relationship with Txn.
//book (List<Book>): One-to-many relationship with Book representing the books borrowed by the student.
