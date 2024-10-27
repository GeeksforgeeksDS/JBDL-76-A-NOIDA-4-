package com.example.SpringAOP.MyPackage;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClass {

    @Pointcut("execution(* com.example.SpringAOP.service.PaymentService.processPayment())")
    public void p1(){}

    @Pointcut("execution(* com.example.SpringAOP.service.PaymentService.deleteTxn())")
    public void p2(){}

    @Before("p1(), p2()")
    public void authenticate() {
        System.out.println("User Authenticated");
    }

    @After("p1()")
    public void commitTxn() {
        System.out.println("Txn Committed successfully");
    }

    @After("execution(* com.example.SpringAOP.service.PaymentService.deleteTxn())")
    public void deleteTxn() {
        System.out.println("Successfully deleted");
    }




}
