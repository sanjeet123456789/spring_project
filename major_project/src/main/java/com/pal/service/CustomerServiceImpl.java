package com.pal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pal.dao.ClassDao;
import com.pal.dao.CustomerDao;
import com.pal.entity.Class_t;
import com.pal.entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDao customerDAO;
	
	

	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}

	////THis is for class table

	
	// This is for class_table
	
	
	@Autowired
	private ClassDao classdao;
	
	@Override
	@Transactional
	public List<Class_t> getClass_ts() {
		return classdao.getClass_ts();
	}

	@Override
	@Transactional
	public void saveClass_t(Class_t theClass_t) {

		classdao.saveClass_t(theClass_t);
	}

	@Override
	@Transactional
	public Class_t getClass_t(int theId) {
		
		return classdao.getClass_t(theId);
	}

	@Override
	@Transactional
	public void deleteClass_t(int theId) {
		
		classdao.deleteClass_t(theId);
	}

	

}





