package com.pal.spring.crud.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pal.spring.crud.demo.entity.Customer;
import com.pal.spring.crud.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowrite the customerService

	@Autowired
	private CustomerService customerService;

	// add mapping for GET/customers

	@GetMapping("/customers")
	public List<Customer> getCustomer() {

		System.out.println(customerService.getCustomers());
		return customerService.getCustomers();

	}
	// add mapping for GET/ customer/{customerid}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);

		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found" + customerId);
		}

		System.out.println(theCustomer);
		return theCustomer;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		// also just in case the pass
		theCustomer.setId(0);
		// this is force a save of new item instead od update
		customerService.saveCustomer(theCustomer);

		return theCustomer;
	}
	// put fubnction to update existing customer

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}

	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {

		Customer tempCustomer = customerService.getCustomer(customerId);

		if (tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found" + customerId);
		}

		customerService.deleteCustomer(customerId);

		return "Deleting customer id" + customerId;
	}

}
