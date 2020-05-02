package com.pal.sanjeet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pal.sanjeet.Dao.StudentRepo;
import com.pal.sanjeet.model.Student;

@Controller
public class StudentController {
	
	
	@Autowired
	StudentRepo repository;
	
	@RequestMapping("/")
	public String home() {
		return "student_form.jsp";
	}
	@RequestMapping("/addstudent")
	public String addstudent(Student student) {
		repository.save(student);
		return "student_form.jsp";
	}
	
	@RequestMapping("/getstudent")
	public ModelAndView getstudent(@RequestParam int sid) {
		
		ModelAndView modelview=new ModelAndView("liststudentbyid.jsp");
		Student student=repository.findById(sid).orElse(new Student());
		
		System.out.println(repository.findByName("pal"));
		System.out.println(repository.findBySidGreaterThan(5));
		
		
		modelview.addObject(student);
		return modelview;
		
		
	}
	
}
