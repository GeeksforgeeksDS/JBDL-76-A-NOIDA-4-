package gfg.org.MinorProject1.Digital.Library.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReturnTxnRequest {

    private String studentEmail;

    private String bookNo;

    private int txnId;

}
