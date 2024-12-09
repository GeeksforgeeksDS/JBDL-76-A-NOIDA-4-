package gfg.org.MinorProject1.Digital.Library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.TxnStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Txn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int paidAmount;


    private int fine;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private TxnStatus txnStatus;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;

}


//Attributes:
//id (int): Primary key, auto-generated.
//paidAmount (int): Amount paid in the transaction.
//createdOn (Date): Timestamp for when the transaction was created.
//updatedOn (Date): Timestamp for the last update.
//txnStatus (TxnStatus): Enum indicating if the book is ISSUED or RETURNED.
//Relationships:
//book (Book): Many-to-one relationship with Book for the book involved in the transaction.
//student (Student): Many-to-one relationship with Student who conducted the transaction.