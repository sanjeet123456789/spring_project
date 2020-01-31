package com.pal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advices for logging
	
	
	//let's start with an @Before advice
	
	
//	@Before("execution(public void addAccount())")
//	@Before("execution(public void com.pal.aopdemo.dao.AccountDAO.addAccount())")
//	@Before("execution(public void add*())")
//	@Before("execution(void add*())")
//	@Before("execution(* add*())")
	
//	@Before("execution(* add*(com.pal.aopdemo.Account))")
//	@Before("execution(* add*(Account))") error
//	@Before("execution(* add*(com.pal.aopdemo.Account,..))")
//	@Before("execution(* add*(..))")
	@Before("execution(* com.pal.aopdemo.dao.*.*(..))")
	public void beforeAccountAdvice() {
		System.out.println("\n@@@===> Executting @Before an addAccount()");
		
	}
}

