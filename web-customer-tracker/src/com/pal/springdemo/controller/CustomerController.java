package com.pal.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pal.springdemo.dao.CustomerDAO;
import com.pal.springdemo.entity.Customer;

import com.pal.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//	// need to inject the customer dao
//	@Autowired
//	private CustomerDAO customerDAO;
	
	//need to inject our customer service 
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the dao
//		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//getting customer from service
		List<Customer> theCustomers=customerService.getCustomers();
		
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		return "customer_add";
	}
	
	
}













































