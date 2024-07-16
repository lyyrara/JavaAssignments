package com.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class AuthorizeService {//AuthorizeService is an Aspect
	
	@Before("execution(* com.service.PaymentService.makePayment())")
    
	public void validateUser() {//validateUser() is an advice
		
		System.out.println("User is getting verified....");
		
		System.out.println("User is Verified....");
	}
	
	@After("execution(* com.service.PaymentService.makePayment())")
	public void closingResources() {//validateUser() is an advice
		
		System.out.println("Resources Closing....");
	}

}

