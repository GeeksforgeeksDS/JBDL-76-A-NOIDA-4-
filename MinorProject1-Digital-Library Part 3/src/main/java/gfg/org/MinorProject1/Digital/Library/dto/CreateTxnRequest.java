package gfg.org.MinorProject1.Digital.Library.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTxnRequest {

    private String studentEmail;
    private String bookNo;
    private int paidAmount;

    //Attributes:
    //email (String): Email of the student issuing the book.
    //bookNo (String): Unique identifier of the book being issued.
    //paidAmount (int): Amount paid for issuing the book.
}
