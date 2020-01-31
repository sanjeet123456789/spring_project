package com.pal.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pal.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	
	
	private static Logger myLogger=Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from spring container
		TrafficFortuneService trafficfortune=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("main program :ArounfDemoApp");
		myLogger.info("calling getFortune");
		
		
		boolean tripwire=true;
		try {
			String data=trafficfortune.getFortune(tripwire);
			myLogger.info("\n My fortune "+data);
		}catch(Exception e) {
			System.out.println("Handle complete");
		}
		
		
		myLogger.info("done");
		
		//close the context
		context.close();
	}

}
