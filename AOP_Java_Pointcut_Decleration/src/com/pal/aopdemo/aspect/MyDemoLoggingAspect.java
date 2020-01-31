package com.pal.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.pal.aopdemo.Account;

@Aspect
@Component
@Order(3)
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
//	@Before("execution(* com.pal.aopdemo.dao.*.*(..))")
//	@Before("forDaoPackage()")
//	public void beforeAccountAdvice() {
//		System.out.println("\n@@@===> Executting @Before an addAccount()");
//		
//	}
	
//	@Before("forDaoPackage()")
//	public void performApiAnalytics() {
//		System.out.println("\n-==>executing  perform APi analytics");
//	}
//	
	@Before("com.pal.aopdemo.aspect.PalAopExpressions.forDaoPackage()")
	public void getApiConfiguration(JoinPoint thejointpoint) {
		System.out.println("\n==> executing before api configuration");
		
		//display the method signature
		
		
		MethodSignature methsig=(MethodSignature) thejointpoint.getSignature();
		System.out.println("Method:"+methsig);
		
		//display method arguments
		
		
		
		//get args
		Object[] args=thejointpoint.getArgs();
		
		//loop thru args
		for(Object temparg:args) {
			System.out.println(temparg);
			
			if(temparg instanceof Account) {
				//downlcast and print account apecific stuff 
				
				Account theAccount=(Account) temparg;
				System.out.println("account name:"+theAccount.getName());
				System.out.println("account name:"+theAccount.getLevel());
			}
		}
	
	}
	
	
	
	
	
	
}

