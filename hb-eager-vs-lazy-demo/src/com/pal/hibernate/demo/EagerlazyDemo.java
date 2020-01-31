package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Course;
import com.pal.hibernate.demo.entity.Instructor;
import com.pal.hibernate.demo.entity.InstructorDetail;

public class EagerlazyDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		
		Session session=factory.getCurrentSession();
		try {
	
			
			//start transaction
			session.beginTransaction();
			
			//get the instructor from DB
			int theId=1;
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			
			System.out.println("sanjeet palinstructor name:"+tempInstructor.getFirstName()+" "+tempInstructor.getLastName());
			System.out.println("dsanjeet"+tempInstructor.getCourses());
			
			//commit transaction
			session.getTransaction().commit();
			//session.close()
			
			session.close();
			//option1:call the getter method when session is open
			System.out.println("dsanjeet"+tempInstructor.getCourses());
			
			System.out.println("pal:done");
		}finally {
			
			factory.close(); 
		}
		
		

	}

}
