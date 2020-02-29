package com.pal.spring.crud.demo.service;

import java.util.List;

import com.pal.spring.crud.demo.entity.Customer;



public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
