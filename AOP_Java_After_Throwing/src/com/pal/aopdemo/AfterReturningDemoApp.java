package com.pal.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pal.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from spring container
		AccountDAO theaccountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		
		// call method to fing the acounts
		List<Account> theAccounts=theaccountDAO.findAccounts(false);
		
		//display the account
		
		System.out.println("\n Main Program :AfterReturningDemoApp");
		System.out.println("--");
		
		
		System.out.println(theAccounts);
		System.out.println("\n ");
		
		//close the context
		context.close();
	}

}
