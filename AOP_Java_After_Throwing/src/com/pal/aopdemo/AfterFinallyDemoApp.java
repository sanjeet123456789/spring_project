package com.pal.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pal.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from spring container
		AccountDAO theaccountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		
		// call method to fing the acounts
		
		
		List<Account> theAccounts= null;
		try {
			// add a boolean flag to simulate  exception
			boolean trip=true;
			theAccounts=theaccountDAO.findAccounts(trip);
			
		}catch(Exception e) {
			System.out.println(e+"\n Caught exception");
		}
		
		
		
		
		
		
		
		//display the account
		
		System.out.println("\n Main Program :AfterExceptionDemoApp");
		System.out.println("--");
		
		
		System.out.println(theAccounts);
		System.out.println("\n ");
		
		//close the context
		context.close();
	}

}
