package com.example;

/**
 * Hello world!
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.ApplicationConfig;
import com.service.PaymentService;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		PaymentService service = context.getBean("paymentService", PaymentService.class);
		
		service.makePayment();
		
	}

}