package gfg.org.MinorProject1.Digital.Library.controller;


import gfg.org.MinorProject1.Digital.Library.dto.CreateTxnRequest;
import gfg.org.MinorProject1.Digital.Library.dto.ReturnTxnRequest;
import gfg.org.MinorProject1.Digital.Library.exceptionlayer.TxnException;
import gfg.org.MinorProject1.Digital.Library.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    private TxnService txnService;


    @PostMapping("/create")
    public int createTxn(@RequestBody CreateTxnRequest createTxnRequest) throws Exception {
        return txnService.createTxn(createTxnRequest);
    }


    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestBody ReturnTxnRequest returnTxnRequest) throws TxnException {
        return ResponseEntity.ok(txnService.returnBook(returnTxnRequest));
    }





}
