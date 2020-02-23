package com.pal.service;

import java.util.List;

import com.pal.entity.Check_busy;
import com.pal.entity.Check_subject;
import com.pal.entity.Class_t;
import com.pal.entity.Customer;
import com.pal.entity.Subject_t;
import com.pal.entity.Teacher_subject_t;
import com.pal.entity.Teachers_t;



public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	
	
	
	public List<Class_t> getClass_ts();

	public void saveClass_t(Class_t theClass_t);

	public Class_t getClass_t(int theId);

	public void deleteClass_t(int theId);
	
	
	
	
	
	
	public List<Teachers_t> getTeachers_ts();

	public void saveTeachers_t(Teachers_t theTeachers_t);

	public Teachers_t getTeachers_t(int theId);

	public void deleteTeachers_t(int theId);
	
	
	
	
	
	public List<Subject_t> getSubject_ts();

	public void saveSubject_t(Subject_t theSubject_t);

	public Subject_t getSubject_t(int theId);

	public void deleteSubject_t(int theId);
	
	
	
	
	
	public List<Teacher_subject_t> getTeacher_subject_ts();

	public void saveTeacher_subject_t(Teacher_subject_t theTeacher_subject_t);

	public Teacher_subject_t getTeacher_subject_t(int theId);

	public void deleteTeacher_subject_t(int theId);
	
	
	
	
	
	
	
	
	public List<Check_subject> getCheck_subject_ts();

	public void saveCheck_subject_t(Check_subject theCheck_subject_t);

	public Check_subject getCheck_subject_t(int theId);

	public void deleteCheck_subject_t(int theId);
	
	
	
	
	public List<Check_busy> getCheck_busy_ts();

	public void saveCheck_busy_t(Check_busy theCheck_busy_t);

	public Check_busy getCheck_busy_t(int theId);

	public void deleteCheck_busy_t(int theId);
	
}
