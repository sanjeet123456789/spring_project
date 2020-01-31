package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Instructor;
import com.pal.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			//get instructor by primary key
			int theId=9;
			Instructor tempInstructor=session.get(Instructor.class,theId);
			System.out.println("Found instructor"+tempInstructor);
			//delete the instructor
			if(tempInstructor!=null) {
				System.out.println("Deleting the instructor"+tempInstructor);
				//Note this will also delete instructor_details
				session.delete(tempInstructor);
			}
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			session.close();
			factory.close();
		}
		
		

	}

}
