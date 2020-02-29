package com.pal.spring.crud.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontPage {
	@GetMapping("/")
	public String showHome() {
		
		return "index";
	}

}
