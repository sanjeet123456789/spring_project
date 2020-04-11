package com.sanjeet.pal.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfilesApplication {
	/* user dev profile run the program and go to run configration in spring boot select profile as dev and under
	 * Environment variable create variable with name= spring.profile.active and value= dev 
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProfilesApplication.class, args);
	}

}
