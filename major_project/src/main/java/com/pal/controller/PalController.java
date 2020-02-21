package com.pal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PalController {

	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	//add request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
	}
	@GetMapping("/admin")
	public String showAdmin() {
		
		return "admin";
	}
	
}
