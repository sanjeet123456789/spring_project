package com.pal.sanjeet.cf_configbasics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class SpringCfConfigServerApplication {
	
	@Value("${company:not found}")
	private String company;
	
	@GetMapping("/")
	public String getCompanyName() {
		return "hi! this module is to test the working of congig server please check the info available at git hub https://github.com/sanjeet123456789/test/blob/master/application.properties company_name="+company;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCfConfigServerApplication.class, args);
	}

}
