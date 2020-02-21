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

import com.pal.entity.Customer;
import com.pal.service.CustomerService;







@Controller
@RequestMapping("/admin/customer")
public class CustomerRestController {

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
	
	@RequestMapping("/showFormForAdd")
	public String showForm(Model theModel) {
		
		
		//create model attribute to bind for
		Customer theCustomer =new Customer();
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		//save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:/admin/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
			Model theModel) {
		//get customer from the service
		Customer theCustomer=customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/admin/customer/list";
	}
}













































