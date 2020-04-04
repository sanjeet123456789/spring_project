package com.pal.security.jwtspringsecurity.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pal.security.jwtspringsecurity.Security.JwtGenerator;
import com.pal.security.jwtspringsecurity.model.JwtUser;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	private JwtGenerator jwtgenerator;
	
	
	public TokenController(JwtGenerator jwtgenerator) {
		
		this.jwtgenerator = jwtgenerator;
	}


	@PostMapping("/{userName}")
	public String generate(@RequestBody final JwtUser jwtuser) {
		
		
		return jwtgenerator.generate(jwtuser);
	}
}
