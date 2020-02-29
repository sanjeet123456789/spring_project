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

import com.pal.dao.TeachersDao;
import com.pal.entity.Class_t;
import com.pal.entity.Teachers_t;
import com.pal.service.CustomerService;

@Controller
@RequestMapping("/admin/teachers_t")
public class TeacherRestController {
	
	@Autowired
	private CustomerService customerService;
	
	
//	@Autowired
//	private TeachersDao pal;
	
	@GetMapping("/listTeachers")
	public String listTeachers_ts(Model theModel) {
		
		List<Teachers_t> theClass_ts=customerService.getTeachers_ts();
		theModel.addAttribute("teachers_ts", theClass_ts);
		
		return "list-teachers_ts";
	}
	
	@RequestMapping("/showFormForAddTeachers")
	public String showFormTeachers_t(Model theModel) {
		Teachers_t theCustomer =new Teachers_t();
		theModel.addAttribute("teachers_t",theCustomer);
		
		return "teachers_t-form";
	}
	
	
	@PostMapping("/saveTeachers_t")
	public String saveTeachers_t(@ModelAttribute("teachers_t") Teachers_t theTeachers_t) {
		//save the customer using our service
		customerService.saveTeachers_t(theTeachers_t);
		
		
		return "redirect:/admin/teachers_t/listTeachers";
	}
	
	
	@GetMapping("/showFormForUpdateTeachers")
	public String showFormForUpdateTeachers(@RequestParam("teachers_tId") int theId,
			Model theModel) {
		//get customer from the service
		Teachers_t theCustomer=customerService.getTeachers_t(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("teachers_t", theCustomer);
		
		
		//send over to our form
		return "teachers_t-form";
	}
	
	@GetMapping("/delete")
	public String deleteTeachers_t(@RequestParam("teachersId") int theId) {
		customerService.deleteTeachers_t(theId);
		return "redirect:/admin/teachers_t/listTeachers";
	}

}
