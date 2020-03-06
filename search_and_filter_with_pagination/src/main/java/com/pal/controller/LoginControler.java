package com.pal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControler {
	
	@GetMapping("/showMyLoginPage")
	public String showLoginPage() {
		return "login";
	}
	@GetMapping("/access-denied")
	public String showAccess_denied() {
		return "access-denied";
	}
}
