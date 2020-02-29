package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		
		Session session=factory.getCurrentSession();
		try {
			
			
			int studentId=1;
			
			//now get a new session and start a transation
			session=factory.getCurrentSession();
			session.beginTransaction();
			//reterieve student based on the i :primary key
			System.out.println("\n Getting student of sdfg"+studentId);
			Student mystudent = session.get(Student.class, studentId);
			System.out.print("Updating student "+mystudent);
			mystudent.setFirstName("hello");
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("done");
		}finally {
			session.close();
			factory.close();
		}
		
		

	}

}
