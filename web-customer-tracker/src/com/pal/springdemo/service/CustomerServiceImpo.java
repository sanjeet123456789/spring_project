package com.pal.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.springdemo.dao.CustomerDAO;
import com.pal.springdemo.entity.Customer;

@Service
public class CustomerServiceImpo implements CustomerService {

	
	//need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

}
