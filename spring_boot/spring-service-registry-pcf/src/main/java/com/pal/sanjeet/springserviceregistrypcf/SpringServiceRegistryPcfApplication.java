package com.pal.sanjeet.springserviceregistrypcf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SpringServiceRegistryPcfApplication {
	
	
	@GetMapping("/")
	public String getMessage() {
		return "this message is from pal-developer..saying have a nice day";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringServiceRegistryPcfApplication.class, args);
	}

}
