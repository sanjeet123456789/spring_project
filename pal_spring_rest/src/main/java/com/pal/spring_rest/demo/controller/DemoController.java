package com.pal.spring_rest.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {

	@GetMapping("/hello")
	public String sayHello() {
		System.out.println("hello from  test()");
		return "hello";
	}
//	@GetMapping("/")
//	public String showHome() {
//		
//		return "hello";
//	}
//	//add request mapping for /leaders
//	@GetMapping("/leaders")
//	public String showLeaders() {
//		
//		return "leaders";
//	}
//	@GetMapping("/admin")
//	public String showAdmin() {
//		
//		return "admin";
//	}
	
}
