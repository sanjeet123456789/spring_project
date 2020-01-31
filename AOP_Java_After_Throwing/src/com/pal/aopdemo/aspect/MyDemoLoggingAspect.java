package com.pal.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
//		myLogger.info("\n@@@===> Executting @Before an addAccount()");
//		
//	}
	
//	@Before("forDaoPackage()")
//	public void performApiAnalytics() {
//		myLogger.info("\n-==>executing  perform APi analytics");
//	}
//	
	
	
	private Logger myLogger=Logger.getLogger(getClass().getName());
	@Around("execution(* com.pal.aopdemo.service.*.getFortune(..))")
	public Object aroungGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		
		//print out method we are advising on
		String method=theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n ===>>> Executing @(Around)on method:"+method  );
		
		
		//get begin timestamp
		long begin =System.currentTimeMillis();
		//now lets execute the method
		Object result=null;
		try {
			result=theProceedingJoinPoint.proceed();
			
			
		}catch(Exception e) {
			myLogger.warning(e.getMessage());
			throw e;
		}
		
		
		//get end timestamp
		long end=System.currentTimeMillis();
		
		//compute duration and display it
		long duration= end-begin;
		myLogger.info("time taken :::"+duration/1000.0 +"second");
		return result;
	}
	
	
	
	@After("execution(* com.pal.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		//print out which we are advising
				String method=theJoinPoint.getSignature().toShortString();
				myLogger.info("\n ===>>> Executing @After(Finally)on method:"+method  );
				
				
	}
	
	
	
	
	
	
	
	@AfterThrowing(
			pointcut="execution(* com.pal.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint thejoinPoint,Throwable theExc) {
		
		
		//print out which we are advising
		String method=thejoinPoint.getSignature().toShortString();
		myLogger.info("\n ===>>> Executing @AfterThrowing  on method:"+method  );
		
		
		//log on execption
		myLogger.info("\n ===>>> Executing exception is:"+theExc  );
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// add a new advice for @AfterReturning on the findAccounts mehod
	
	@AfterReturning(pointcut="execution(* com.pal.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningAccountsAdvice(JoinPoint theJoinPoint,List<Account> result){
		
		//printout which method we are advesing on
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ===>>> Executing @AfterReturning on method:"+method  );
		
		myLogger.info(result.toString());
		
		
		//print out t he results of the method call
		// we can modify list add,remove,update
		
		if(!result.isEmpty()) {
			
			Account tempAccount=result.get(0);
			tempAccount.setName("homies");
			
		}
		
		
		//let's post-process the data 
		
		
		//convert the accoount names to uppercase
		
		converAccountNamesToUpperCase(result);
		
		
		
		myLogger.info("\n ===>>> result is:"+result  );
		
		
		
		
	}
	
	
	private void converAccountNamesToUpperCase(List<Account> result) {
		//loop throug the account 
		for(Account tempAccout:result) {
			
		
		//get upper version of name
		String theUpperName=tempAccout.getName().toUpperCase();
		//update the name on the account
		tempAccout.setName(theUpperName);
		}
	}


























	@Before("com.pal.aopdemo.aspect.PalAopExpressions.forDaoPackage()")
	public void getApiConfiguration(JoinPoint thejointpoint) {
		myLogger.info("\n==> executing before api configuration");
		
		//display the method signature
		
		
		MethodSignature methsig=(MethodSignature) thejointpoint.getSignature();
		myLogger.info("Method:"+methsig);
		
		//display method arguments
		
		
		
		//get args
		Object[] args=thejointpoint.getArgs();
		
		//loop thru args
		for(Object temparg:args) {
			myLogger.info(temparg.toString());
			
			if(temparg instanceof Account) {
				//downlcast and print account apecific stuff 
				
				Account theAccount=(Account) temparg;
				myLogger.info("account name:"+theAccount.getName());
				myLogger.info("account name:"+theAccount.getLevel());
			}
		}
	
	}
	
	
	
	
	
	
}

