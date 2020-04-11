package com.sanjeet.pal.profiles;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
//this file will get executed when we execute the dev profile
@Profile("dev")
@Configuration
public class DevConfig {
	@PostConstruct
	public void sanjeet() {
		System.out.println("executing post construct sanjeet");
	}
	
}
