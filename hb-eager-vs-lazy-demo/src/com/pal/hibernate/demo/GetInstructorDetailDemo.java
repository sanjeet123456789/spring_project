package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Instructor;
import com.pal.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		
		Session session=factory.getCurrentSession();
		try {
			
			//start transaction
			session.beginTransaction();
			
			//get the instructor detail
			int theId=299;
			//print the instructor detail
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class,theId );
			//Print the associated detail
			
			System.out.println("tempInstructor"+tempInstructorDetail);
			System.out.println("the asoociated instructor"+tempInstructorDetail.getInstructor());
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}
		catch(Exception exc) {exc.printStackTrace();}
		finally {
			session.close(); 
			factory.close();
		}
		
		

	}

}
