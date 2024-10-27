package com.example.SpringAOP.service;

import org.springframework.stereotype.Service;

import java.util.SortedMap;

@Service
public class PaymentService { //Bussiness logic

    public void processPayment() {
       // System.out.println("User Authenticated");

        System.out.println("Processing payment ...");

//        System.out.println("Txn Committed successfully");

    }

    public void deleteTxn(){
       // System.out.println("User Athenticated");

        System.out.println("Deleting Txn ...");

//        System.out.println("Successfully deleted");

    }
}
