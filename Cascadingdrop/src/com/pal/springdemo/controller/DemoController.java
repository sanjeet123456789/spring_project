package com.pal.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pal.springdemo.service.CountryService;

@Controller
@RequestMapping("/")
public class DemoController {
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		System.out.println("this i dasfads from controller");
		modelMap.put("countries",countryService.findAll());
		
		
		
		
		return "demo/index";
	}
}
