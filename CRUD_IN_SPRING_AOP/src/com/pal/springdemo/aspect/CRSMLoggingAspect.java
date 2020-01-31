package com.pal.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRSMLoggingAspect {
	
	//setup logger
	private Logger myLogger=Logger.getLogger(getClass().getName());
	//set pointcut declaration
	@Pointcut("execution(* com.pal.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//do the samefor service and dao
	@Pointcut("execution(* com.pal.service.controller.*.*(..))")
	private void forServicePackage() {}
	@Pointcut("execution(* com.pal.dao.controller.*.*(..))")
	private void forDaoPackage() {}
	
	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()  ")
	private void forAppFlow() {}
	//add @Before advice
	 
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//display method we are calling
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("@==>in @Before :from method:"+theMethod);

		
		
		//display the argumnet to method
		
		//get the args
		Object[] args=theJoinPoint.getArgs();
		//loop thru and display
		
		for(Object temparg:args) {
			myLogger.info("==>argument:"+temparg);
		}
		
		
		
	}
	//add@AfterReturning advice
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			
			)
	public void afterReturning(JoinPoint theJoinPoint,Object theResult) {
		//display method we are returning from
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("@==>in @AfterReturning :from method:"+theMethod);
		
		//display data returned
		
		myLogger.info("@===>result:"+theResult);
	}
}
