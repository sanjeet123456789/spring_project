package com.pal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pal.dao.Check_busyDao;
import com.pal.dao.Check_subjectDao;
import com.pal.dao.ClassDao;
import com.pal.dao.CustomerDao;
import com.pal.dao.SubjectDao;
import com.pal.dao.Teacher_subjectDao;
import com.pal.dao.TeachersDao;
import com.pal.entity.Check_busy;
import com.pal.entity.Check_subject;
import com.pal.entity.Class_t;
import com.pal.entity.Customer;
import com.pal.entity.Subject_t;
import com.pal.entity.Teacher_subject_t;
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
	
//this is for teachers _subject_t
	
	@Autowired
	private Teacher_subjectDao teacher_subjectdao;
	
	@Override
	@Transactional
	public List<Teacher_subject_t> getTeacher_subject_ts() {
		return teacher_subjectdao.getTeacher_subject_ts();
	}

	@Override
	@Transactional
	public void saveTeacher_subject_t(Teacher_subject_t theTeacher_subject_t) {

		teacher_subjectdao.saveTeacher_subject_t(theTeacher_subject_t);
	}

	@Override
	@Transactional
	public Teacher_subject_t getTeacher_subject_t(int theId) {
		
		return teacher_subjectdao.getTeacher_subject_t(theId);
	}

	@Override
	@Transactional
	public void deleteTeacher_subject_t(int theId) {
		
		teacher_subjectdao.deleteTeacher_subject_t(theId);
	}
	
	
	//This iis for cheksubject 
	///This is  for check subject
	
	@Autowired
	private Check_subjectDao check_subjectdao;
	
	@Override
	@Transactional
	public List<Check_subject> getCheck_subject_ts() {
		System.out.println("hello");
		return check_subjectdao.getCheck_subject_ts();
	}

	@Override
	@Transactional
	public void saveCheck_subject_t(Check_subject theCheck_subject_t) {

		check_subjectdao.saveCheck_subject_t(theCheck_subject_t);;
	}

	@Override
	@Transactional
	public Check_subject getCheck_subject_t(int theId) {
		return check_subjectdao.getCheck_Subject_t(theId);
	}
	

	@Override
	@Transactional
	public void deleteCheck_subject_t(int theId) {
		System.out.println("hello");
		check_subjectdao.deleteCheck_subject_t(theId);
	}
	
	///this is for check busy
	//THisi  is for check busy
	@Autowired
	private Check_busyDao check_busydao;

	@Override
	@Transactional
	public List<Check_busy> getCheck_busy_ts() {
		System.out.println("under service");
		return check_busydao.getCheck_busy_ts();
	}

	@Override
	@Transactional
	public void saveCheck_busy_t(Check_busy theCheck_busy_t) {
		check_busydao.saveCheck_busy_t(theCheck_busy_t);
		
	}

	@Override
	@Transactional
	public Check_busy getCheck_busy_t(int theId) {
		// TODO Auto-generated method stub
		return check_busydao.getCheck_busy_t(theId);
	}

	@Override
	@Transactional
	public void deleteCheck_busy_t(int theId) {
		check_busydao.deleteCheck_busy_t(theId);
		
	}
	
	
	
	
	
}





