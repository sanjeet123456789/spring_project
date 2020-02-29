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
import com.pal.entity.Check_subject;
import com.pal.entity.Class_t;
import com.pal.service.CustomerService;

@Controller
@RequestMapping("/admin/check_subject_t")
public class Check_subjectRestController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/listCheck_subject")
	public String listCheck_subject_ts(Model theModel) {
		
//		List<Check_subject_t> theCheck_subject_ts=customerService.getCheck_subject_ts();
//		theModel.addAttribute("check_subject_ts", theCheck_subject_ts);
		List<Check_subject> theCheck_subject_ts=customerService.getCheck_subject_ts();
		theModel.addAttribute("check_subject_ts", theCheck_subject_ts);
		return "list-check_subject_ts";
	}
	
	@RequestMapping("/showFormForAddCheck_subject")
	public String showFormCheck_subject_t(Model theModel) {
		Check_subject theCustomer =new Check_subject();
		theModel.addAttribute("check_subject_t",theCustomer);
		
		return "check_subject_t-form";
	}
	
	
	@PostMapping("/saveCheck_subject_t")
	public String saveCheck_subject_t(@ModelAttribute("check_subject_tId") Check_subject theCheck_subject_t) {
		customerService.saveCheck_subject_t(theCheck_subject_t);
		
		
		return "redirect:/admin/check_subject_t/listCheck_subject";
	}
	
	
	@GetMapping("/showFormForUpdateCheck_subject")
	public String showFormForUpdateCheck_subject(@RequestParam("check_subject_tId") int theId,
			Model theModel) {
		//get customer from the service
		Check_subject theCheck_subject_t=customerService.getCheck_subject_t(theId);
		theModel.addAttribute("check_subject_t", theCheck_subject_t);
		
		
		//send over to our form
		return "check_subject_t-form";
	}
	
	@GetMapping("/delete")
	public String deleteClass_t(@RequestParam("check_subject_tId") int theId) {
		customerService.deleteCheck_subject_t(theId);
		return "redirect:/admin/check_subject_t/listCheck_subject";
	}

}
