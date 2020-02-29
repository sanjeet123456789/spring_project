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

import com.pal.entity.Check_busy;
import com.pal.entity.Check_subject;
import com.pal.service.CustomerService;

@Controller
@RequestMapping("/admin/check_busy_t")
public class Check_busyRestController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/listCheck_busy")
	public String listCheck_busy_ts(Model theModel) {
		
//		List<Check_subject_t> theCheck_subject_ts=customerService.getCheck_subject_ts();
//		theModel.addAttribute("check_subject_ts", theCheck_subject_ts);
		System.out.println("hello");
		List<Check_busy> theCheck_subject_ts=customerService.getCheck_busy_ts();
		
		System.out.println("mosdaf");
		theModel.addAttribute("check_busy_ts", theCheck_subject_ts);
		return "list-check_busy_ts";
	}
	
	@RequestMapping("/showFormForAddCheck_busy")
	public String showFormCheck_busy_t(Model theModel) {
		Check_busy theCustomer =new Check_busy();
		theModel.addAttribute("check_busy_t",theCustomer);
		
		return "check_busy_t-form";
	}
	
	
	@PostMapping("/saveCheck_busy_t")
	public String saveCheck_busy_t(@ModelAttribute("check_busy_tId") Check_busy theCheck_busy_t) {
		customerService.saveCheck_busy_t(theCheck_busy_t);
		
		
		return "redirect:/admin/check_busy_t/listCheck_busy";
	}
	
	
	@GetMapping("/showFormForUpdateCheck_busy")
	public String showFormForUpdateCheck_busy(@RequestParam("check_busy_tId") int theId,
			Model theModel) {
		//get customer from the service
		Check_busy theCheck_busy_t=customerService.getCheck_busy_t(theId);
		theModel.addAttribute("check_busy_t", theCheck_busy_t);
		
		
		//send over to our form
		return "check_busy_t-form";
	}
	
	@GetMapping("/delete")
	public String deleteCheck_busy_t(@RequestParam("check_busy_tId") int theId) {
		customerService.deleteCheck_busy_t(theId);
		return "redirect:/admin/check_busy_t/listCheck_busy";
	}

}
