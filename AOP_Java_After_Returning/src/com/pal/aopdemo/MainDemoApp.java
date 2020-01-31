package com.pal.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pal.aopdemo.dao.AccountDAO;
import com.pal.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from spring container
		AccountDAO theaccount=context.getBean("accountDAO",AccountDAO.class);
		
		//get  membership bean from spring container
		
		MembershipDAO themembership=context.getBean("membershipDAO",MembershipDAO.class);
		
		// call the business method
		Account myaccount=new Account();
		myaccount.setName("sanjeet");
		myaccount.setLevel("45B");
		theaccount.addAccount(myaccount,false);
		theaccount.dowork();
		
		themembership.addAccount();
		themembership.sleeping();
		// call the geter /setter methods
		theaccount.setName("blog");
		theaccount.setServiceCode("CAT_434");
		
		
		String name=theaccount.getName();
		String code=theaccount.getServiceCode();
		
		
		// do it again
		
		System.out.println("\n let call it again \n");
		
		//call it again
	
		
		//close the context
		context.close();
//		System.out.println("done");
	}

}
