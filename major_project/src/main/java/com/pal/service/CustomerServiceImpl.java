package com.pal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pal.dao.ClassDao;
import com.pal.dao.CustomerDao;
import com.pal.dao.SubjectDao;
import com.pal.dao.TeachersDao;
import com.pal.entity.Class_t;
import com.pal.entity.Customer;
import com.pal.entity.Subject_t;
import com.pal.entity.Teachers_t;


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

	
		//This is for Teachers_t
	//this is for Teacjhers_table
	@Autowired
	private TeachersDao teachersdao;
	
	@Override
	@Transactional
	public List<Teachers_t> getTeachers_ts() {
		return teachersdao.getTeachers_ts();
	}

	@Override
	@Transactional
	public void saveTeachers_t(Teachers_t theTeachers_t) {

		teachersdao.saveTeachers_t(theTeachers_t);
	}

	@Override
	@Transactional
	public Teachers_t getTeachers_t(int theId) {
		
		return teachersdao.getTeachers_t(theId);
	}

	@Override
	@Transactional
	public void deleteTeachers_t(int theId) {
		
		teachersdao.deleteTeachers_t(theId);
	}
	
	
	//Thisi is for subject_T
	//This is sdfadsfad for SUbject_tables
	
	@Autowired
	private SubjectDao subjectdao;
	
	@Override
	@Transactional
	public List<Subject_t> getSubject_ts() {
		return subjectdao.getSubject_ts();
	}

	@Override
	@Transactional
	public void saveSubject_t(Subject_t theSubject_t) {

		subjectdao.saveSubject_t(theSubject_t);
	}

	@Override
	@Transactional
	public Subject_t getSubject_t(int theId) {
		
		return subjectdao.getSubject_t(theId);
	}

	@Override
	@Transactional
	public void deleteSubject_t(int theId) {
		
		subjectdao.deleteSubject_t(theId);
	}
	

}





