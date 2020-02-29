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

import com.pal.dao.SubjectDao;
import com.pal.dao.Teacher_subjectDao;
import com.pal.entity.Class_t;
import com.pal.entity.Teacher_subject_t;
import com.pal.service.CustomerService;

@Controller
@RequestMapping("/admin/teacher_subject_t")
public class Teacher_subjectRestController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private Teacher_subjectDao pal;
	

	
	@GetMapping("/listTeacher_subject")
	public String listTeacher_subject_ts(Model theModel) {
		
		List<Teacher_subject_t> theTeacher_subject_ts=customerService.getTeacher_subject_ts();
		theModel.addAttribute("teacher_subject_ts", theTeacher_subject_ts);
		
		return "list-Teacher_subject_ts";
	}
	
	@RequestMapping("/showFormForAddTeacher_subject")
	public String showFormTeacher_subject_t(Model theModel) {
		Teacher_subject_t theCustomer =new Teacher_subject_t();
		theModel.addAttribute("teacher_subject_t",theCustomer);
		
		return "teacher_subject_t-form";
	}
	
	
	@PostMapping("/saveTeacher_subject_t")
	public String saveTeacher_subject_t(@ModelAttribute("teacher_subject_t") Teacher_subject_t theTeacher_subject_t) {
		//save the customer using our service
		customerService.saveTeacher_subject_t(theTeacher_subject_t);
		return "redirect:/admin/teacher_subject_t/listTeacher_subject";
	}
	
	
	@GetMapping("/showFormForUpdateTeacher_subject")
	public String showFormForUpdateClass(@RequestParam("teacher_subject_tId") int theId,
			Model theModel) {
		//get customer from the service
		Teacher_subject_t theCustomer=customerService.getTeacher_subject_t(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("teacher_subject_t", theCustomer);
		
		
		//send over to our form
		return "teacher_subject_t-form";
	}
	
	@GetMapping("/delete")
	public String deleteTeacher_subject_t(@RequestParam("teacher_subject_tId") int theId) {
		customerService.deleteTeacher_subject_t(theId);
		return "redirect:/admin/teacher_subject_t/listTeacher_subject";
	}

}
