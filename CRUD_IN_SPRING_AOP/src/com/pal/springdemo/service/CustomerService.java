package com.pal.springdemo.service;

import java.util.List;

import com.pal.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public  void deleteCustomer(int theId);
}
