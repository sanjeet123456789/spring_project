package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTestApplication.class, args);
		System.out.print("this is goo");
//		Customer c=context.getBean(Customer.class);
//		c.display();
		
	}

}
