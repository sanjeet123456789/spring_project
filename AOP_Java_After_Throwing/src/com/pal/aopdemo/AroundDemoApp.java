package com.pal.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pal.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from spring container
		TrafficFortuneService trafficfortune=context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("main program :ArounfDemoApp");
		System.out.println("calling getFortune");
		String data=trafficfortune.getFortune();
		
		System.out.println("\n My fortune "+data);
		System.out.println("done");
		
		//close the context
		context.close();
	}

}
