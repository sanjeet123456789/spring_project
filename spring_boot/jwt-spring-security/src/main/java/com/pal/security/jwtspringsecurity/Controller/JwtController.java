package com.pal.security.jwtspringsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class JwtController {
	
	@GetMapping
	public String hello() {
		return "hello world";
	}

}
