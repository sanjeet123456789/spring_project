package com.pal.spring.mysqlauthentication.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/rest/home")
@RestController
public class PalController {
	
	@GetMapping("/all")
	public String home() {
		return "welcome home";
	}
	@PreAuthorize("hasAnyRole('ADMIN')") //preAUthorize or method level authorization
	@GetMapping("/secured/all")
	public String secureHello() {
		return "secure home page";
	}
	@RequestMapping("/accessdenied")
	public String accessdenied(HttpServletRequest request) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			System.out.println("User '" + auth.getName() + "' attempted to access the protected URL: ");
			System.out.println("<br>auth : "+auth.isAuthenticated());
			System.out.println("<br>Role : "+auth.getAuthorities());
			System.out.println("<br>Error Page : "+request.getRequestURL());
		}
		return "not accessdenied";
	}
	
	
	@GetMapping("/secured/random")
	public String alternate() {
		return "alternate";
	}
	
}
