package com.pal.sanjeet.hystrixcircuitbreaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class SpringHystrixCircuitBreakerPcfApplication {
	@Autowired
	private RestTemplate template;
	
	
	@GetMapping("/")
	public String getAPIResResponse() {
		return template.getForObject("http://dummy.restapiexample.com/api/v1/employees", String.class);
	}
	@GetMapping("/api")
	@HystrixCommand(fallbackMethod="fallbackmethod")
	public String getfailAPIResResponse() {
		return template.getForObject("http://dummyx.restapiexample.com/api/v1/employees", String.class);
	}
	private String fallbackmethod() {
		return "API is not working,try again..";
	}
	
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringHystrixCircuitBreakerPcfApplication.class, args);
	}

}
