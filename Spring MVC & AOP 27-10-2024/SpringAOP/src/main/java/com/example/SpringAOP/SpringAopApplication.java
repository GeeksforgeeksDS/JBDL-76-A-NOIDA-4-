package com.example.SpringAOP;

import com.example.SpringAOP.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopApplication  {

//	@Autowired
//	private PaymentService paymentService;

	public static void main(String[] args) {

		SpringApplication.run(SpringAopApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		paymentService.processPayment();
//		paymentService.deleteTxn();
//	}
}
