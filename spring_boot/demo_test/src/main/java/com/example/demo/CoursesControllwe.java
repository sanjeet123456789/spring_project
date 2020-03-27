package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoursesControllwe {
	/*@RequestMapping("/course")
	//@ResponseBody //response body return the text return by the class not the jsp file
	public String  course(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String courseName=req.getParameter("course_name");
		System.out.println(courseName);
		
		session.setAttribute("course_name", courseName);
		return "courses";
	}*/
	
	/*@RequestMapping("/courses")
	public String courses(@RequestParam("c_name")String course_name,HttpSession session) {
		
		session.setAttribute("course_name", course_name);
		return "courses";
	}*/
	
	//Dispatcher servlet need two thing data and viewName
	@RequestMapping("/courses_model")
	public ModelAndView courses(@RequestParam("c_name")String course_name) {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("course_name",course_name);
		
		mv.setViewName("courses");
		return mv;
	}




}
