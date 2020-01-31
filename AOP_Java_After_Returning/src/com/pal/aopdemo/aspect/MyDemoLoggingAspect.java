package com.pal.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	
	
	// add a new advice for @AfterReturning on the findAccounts mehod
	
	@AfterReturning(pointcut="execution(* com.pal.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningAccountsAdvice(JoinPoint theJoinPoint,List<Account> result){
		
		//printout which method we are advesing on
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("\n ===>>> Executing @AfterReturning on method:"+method  );
		
		System.out.println(result);
		
		
		//print out the results of the method call
		// we can modify list add,remove,update
		
		if(!result.isEmpty()) {
			
			Account tempAccount=result.get(0);
			tempAccount.setName("homies");
			
		}
		
		
		//let's post-process the data 
		
		
		//convert the accoount names to uppercase
		
		converAccountNamesToUpperCase(result);
		
		
		
		System.out.println("\n ===>>> result is:"+result  );
		
		
		
		
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

