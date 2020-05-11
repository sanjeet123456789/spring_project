package com.pal.sanjeet.spring.Cloud_function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCloudFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudFunctionApplication.class, args);
	}
	
	@Bean
	public Function<String,String> function(){
		return input -> input;
	}
	
	@Bean
	public Consumer<String> consume(){
		return input ->{
			 System.out.println("hello input"+input);
			};	
	}
	
	@Bean
	public Supplier<String> supply(){
		return ()-> "hello sanjeet";
	}
	
}
