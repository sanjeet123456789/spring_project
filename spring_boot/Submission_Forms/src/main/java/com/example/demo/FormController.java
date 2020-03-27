package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@Autowired
	CustomerRepository repo;
	
	
	@RequestMapping("/")
	public String details() {
		return "sanjeet";
	}
	@RequestMapping("/details")
	public String details(Customer c) {
		repo.save(c);
		return "sanjeet";
	}
	@RequestMapping("/getdetails")
	public String getdetails() {
		return "viewCustomerDetails";
	}
	
	
	
	@PostMapping("/getdetails")
	public ModelAndView getdetails(@RequestParam int c_id) {
		ModelAndView mv=new ModelAndView("Retrive");
		Customer customers=repo.findById(c_id).orElse(null);
		mv.addObject(customers);
		System.out.println(customers);
		return mv;
		
	}
	
	//rest API before running please insert statement in m2-console directly
	/*@RequestMapping("/customers")
	@ResponseBody
	public String getCustomers() {
		return repo.findAll().toString();
	}*/
	
	//Storing the result in a String
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customer> getCustomers() {
		return repo.findAll();
	}
	
	
	
	@RequestMapping("customers/{c_id}")
	@ResponseBody
	public Optional<Customer> getCustomer(@PathVariable int c_id) {
		return repo.findById(c_id);
	}
	//creating a customer
	@PostMapping("/customers")
	public Customer getCustomers3(@RequestBody Customer customer){
		repo.save(customer);
		return customer;
	}
	
	//Deleting a customer
	@DeleteMapping("/customer/{c_id}")
	public Customer getCustomer4(@PathVariable("c_id") int c_id) {
		Customer cust=repo.getOne(c_id);
		repo.delete(cust);
		return cust;
	}
	
	//Updating customer details
	@PutMapping(path="/customer",consumes= {"application/json"})
	public Customer getCustomer5(@RequestBody Customer customers) {
		repo.save(customers);
		return customers;
	}
	
	
	
	
	
	
	///use it for without h2 database conenction
	/*@GetMapping("/sanjeet")
	public String Home() {
		return "sanjeet";
	}*/
	
	
	
	/*
	@PostMapping("/details")
	public String viewdetails(@RequestParam("c_id") int c_id,
			@RequestParam("c_name") String c_name,
			@RequestParam("c_email") String c_email,ModelMap modelMap) {
		modelMap.put("c_id", c_id);
		modelMap.put("c_name",c_name);
		modelMap.put("c_email",c_email);
		return "viewCustomerDetails";
		
	}*/
}
