package com.pal.service;

import java.util.List;

import com.pal.entity.Class_t;
import com.pal.entity.Customer;



public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	
	
	
	public List<Class_t> getClass_ts();

	public void saveClass_t(Class_t theClass_t);

	public Class_t getClass_t(int theId);

	public void deleteClass_t(int theId);
	
	
	
	
}
