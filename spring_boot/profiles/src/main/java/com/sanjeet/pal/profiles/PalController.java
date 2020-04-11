package com.sanjeet.pal.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pal/home")
@RestController
public class PalController {
	
	
	@Value("${spring.message}")
	private String message;
	
	@GetMapping("/all")
	public String all() {
		return message;
	}
}
