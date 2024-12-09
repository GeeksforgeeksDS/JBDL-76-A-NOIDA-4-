package gfg.org.MinorProject1.Digital.Library.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private UUID studentId;

    private String name;


    @Column(unique = true, nullable = false)
    private String email;

    private String address;

    private String password;

    private String authority;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Book> books;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Txn> txn;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(authority.split(","))
                .map(authority -> new SimpleGrantedAuthority(authority))
                .toList();
    }


    @Override
    public String getUsername() {
        return email;
    }


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
