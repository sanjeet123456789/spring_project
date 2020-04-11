package com.pal.sanjeet.basics.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class palController {
	
	@GetMapping("/welcome")
	public String hello(@RequestParam("name") String name,Model model) {
		
		String message="hello "+name+" welcome to pal-developer community";
		model.addAttribute("hello_message", message);
		return "home";
	}
	@GetMapping("/")
   	public String redirect() {
      		return "redirect:home";
   	}
	
	
	
	
	
	
}
