package com.pal.sanjeet.Cloud_function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCloudFunctionAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudFunctionAwsApplication.class, args);
	}
	
	@Bean
	public Function<String,String> function(){return input->input;}
	
	@Bean
	public Consumer<String> consume(){return input-> System.out.println("hello"+input);}
	
	@Bean Supplier<String> supply(){return()->"hello sanjeet";}
}
