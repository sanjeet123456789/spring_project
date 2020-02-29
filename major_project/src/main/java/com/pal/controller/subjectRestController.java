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

import com.pal.entity.Class_t;
import com.pal.entity.Subject_t;
import com.pal.service.CustomerService;

@Controller
@RequestMapping("/admin/subject_t")
public class subjectRestController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/listSubject")
	public String listSubject_ts(Model theModel) {
		
		List<Subject_t> theSubject_ts=customerService.getSubject_ts();
		theModel.addAttribute("subject_ts", theSubject_ts);
		
		return "list-subject_ts";
	}
	
	@RequestMapping("/showFormForAddSubject")
	public String showFormSubejct_t(Model theModel) {
		Subject_t theCustomer =new Subject_t();
		theModel.addAttribute("subject_t",theCustomer);
		
		return "subject_t-form";
	}
	
	
	@PostMapping("/saveSubject_t")
	public String saveSubject_t(@ModelAttribute("subject_t") Subject_t theSubject_t) {
		//save the customer using our service
		customerService.saveSubject_t(theSubject_t);
		
		
		return "redirect:/admin/subject_t/listSubject";
	}
	
	
	@GetMapping("/showFormForUpdateSubject")
	public String showFormForUpdateSubject(@RequestParam("subject_tId") int theId,
			Model theModel) {
		//get customer from the service
		Subject_t theCustomer=customerService.getSubject_t(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("subject_t", theCustomer);
		
		
		//send over to our form
		return "subject_t-form";
	}
	
//	@GetMapping("/delete")
//	public String deleteSubject_t(@RequestParam("subject_tId") int theId) {
//		customerService.deleteSubject_t(theId);
//		return "redirect:/admin/subject_t/listSubject";
//	}
	
	@GetMapping("/delete")
	public String deleteSubject_t(@RequestParam("subject_tId") int theId) {
		customerService.deleteSubject_t(theId);
		System.out.println("deleted");
		return "redirect:/admin/subject_t/listSubject";
	}
	
	

}
