package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.sun.research.ws.wadl.Application;
@ComponentScan
@SpringBootApplication
public class SubmissionFormsApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SubmissionFormsApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SubmissionFormsApplication.class, args);
	}

}
