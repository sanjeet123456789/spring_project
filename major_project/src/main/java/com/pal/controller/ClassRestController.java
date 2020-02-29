package com.pal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pal.dao.Check_subjectDao;
import com.pal.entity.Class_t;
import com.pal.service.CustomerService;

@Controller
@RequestMapping("/admin/class_t")
public class ClassRestController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private Check_subjectDao pal;
	

	
	@GetMapping("/listClass")
	public String listClass_ts(Model theModel) {
		
		List<Class_t> theClass_ts=customerService.getClass_ts();
		theModel.addAttribute("class_ts", theClass_ts);
		
		return "list-class_ts";
	}
	
	@RequestMapping("/showFormForAddClass")
	public String showFormClass_t(Model theModel) {
		Class_t theCustomer =new Class_t();
		theModel.addAttribute("class_t",theCustomer);
		
		return "class_t-form";
	}
	
	
	@PostMapping("/saveClass_t")
	public String saveClass_t(@ModelAttribute("class_t") Class_t theClass_t) {
		//save the customer using our service
		customerService.saveClass_t(theClass_t);
		
		
		return "redirect:/admin/class_t/listClass";
	}
	
	
	@GetMapping("/showFormForUpdateClass")
	public String showFormForUpdateClass(@RequestParam("class_tId") int theId,
			Model theModel) {
		//get customer from the service
		Class_t theCustomer=customerService.getClass_t(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("class_t", theCustomer);
		
		
		//send over to our form
		return "class_t-form";
	}
	
	@GetMapping("/delete")
	public String deleteClass_t(@RequestParam("customerId") int theId) {
		customerService.deleteClass_t(theId);
		return "redirect:/admin/class_t/listClass";
	}

}
