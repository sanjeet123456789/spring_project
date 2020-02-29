package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		
		Session session=factory.getCurrentSession();
		try {
			//use the session object to save the
			
			
			//create a student object
			System.out.print("Creating a new student object");
			Student tempStudent=new Student("h2o2","water2","wate2r@gmail.com");
			
			
			//start a tranction
			session.beginTransaction();
			
			
			//save the student object
			System.out.println("saving the object");
			System.out.println(tempStudent);
			session.save(tempStudent);
			session.getTransaction().commit();
			//My new code
			
			
			
			//find out the student's id
			System.out.println("saved studnet generated id"+tempStudent.getId());
			//now get a new session and start a transation
			session=factory.getCurrentSession();
			session.beginTransaction();
			//reterieve student based on the i :primary key
			System.out.println("\n Getting student of "+tempStudent.getId());
			Student mystudent = session.get(Student.class, tempStudent.getId());
			System.out.print("get complete "+mystudent);
			//commit the transaction
			session.getTransaction().commit();
			
			
			
			//NEW CODE
			session=factory.getCurrentSession();
			session.beginTransaction();
			//update email for all student
			System.out.println("UPdating email");
			session.createQuery("update Student set email='foo@gmail.com'")
			.executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("done");
		}finally {
			session.close();
			factory.close();
		}
		
		

	}

}
