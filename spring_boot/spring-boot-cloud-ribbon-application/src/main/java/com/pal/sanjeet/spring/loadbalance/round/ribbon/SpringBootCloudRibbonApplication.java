package com.pal.sanjeet.spring.loadbalance.round.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/* chat is a client aplication running on different instance localhost:8080,localhost:8081,localhost:8082 
 * simple rest application running on different port */
/* round robbin application*/
@SpringBootApplication
@RestController
@RibbonClient(name="chat",configuration=RibbonConfiguration.class) 
public class SpringBootCloudRibbonApplication {
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/invoke")
	public String invokingchatApplication() {
		//String url="http://localhost:8080/sanjeet/chatting";
		/* url of application running on different port 8080,8081,8082 and send rest message on hitting server*/
		String url="http://chat/sanjeet/chatting"; //cleint name will handle by application.yml search for running  serverList 
		
		return template.getForObject("", String.class); 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudRibbonApplication.class, args);
	}
	
	
	@Bean
	@LoadBalanced
	public  RestTemplate template() {
		return new RestTemplate();
	}

}
