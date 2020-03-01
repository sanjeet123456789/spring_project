package com.pal.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pal.springdemo.service.CityService;
import com.pal.springdemo.service.CountryService;
import com.pal.springdemo.service.StateService;

@Controller
@RequestMapping("/")
public class DemoController {
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		System.out.println("this i dasfads from controller");
		modelMap.put("countries",countryService.findAll());
		
		
		
		
		return "demo/index";
	}
	
	@RequestMapping(value="demo/loadcountry/{id}",method=RequestMethod.GET)
	public String countryid(@PathVariable("id") int id,ModelMap modelMap) {
		System.out.println("this i dasfads from controller");
		modelMap.put("country",countryService.find(id));
		
		
		
		
		return "demo/country";
	}
	
	
	@RequestMapping(value="demo/loadState/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String loadState(@PathVariable("id") int id) {
		Gson gson =new Gson();
		return gson.toJson(stateService.findByCountry(id));
		
	}
	
	
	
	@RequestMapping(value="demo/loadCity/{id}",method=RequestMethod.GET)
	@ResponseBody
	public String loadCity(@PathVariable("id") int id) {
		Gson gson =new Gson();
		return gson.toJson(cityService.findByState(id));
		
	}
	
}
