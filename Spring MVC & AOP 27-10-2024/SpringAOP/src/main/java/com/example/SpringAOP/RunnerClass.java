package com.example.SpringAOP;

import com.example.SpringAOP.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class RunnerClass implements CommandLineRunner {

    @Autowired
    private PaymentService paymentService;

    @Override
    public void run(String... args) throws Exception {
        paymentService.processPayment();
    }
}
