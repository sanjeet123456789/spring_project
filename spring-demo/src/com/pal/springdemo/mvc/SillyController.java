package com.pal.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/suck")
public class SillyController {

	@RequestMapping("/showForm")
	public String displyTheForm() {
		return "silly";
	}
}
