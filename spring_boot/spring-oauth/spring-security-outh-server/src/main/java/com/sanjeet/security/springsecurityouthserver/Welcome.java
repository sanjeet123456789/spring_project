package com.sanjeet.security.springsecurityouthserver;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/sanjeet")
public class Welcome {
	@GetMapping("/principal")
	public Principal User(Principal principal) {
		return principal;
	}
	@GetMapping
	public String welcome() {
		return "welcome";
	}

}
