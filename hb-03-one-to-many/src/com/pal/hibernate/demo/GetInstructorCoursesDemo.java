package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Course;
import com.pal.hibernate.demo.entity.Instructor;
import com.pal.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
			
			
			System.out.println("instructor name:"+tempInstructor.getFirstName()+" "+tempInstructor.getLastName());
			System.out.println(tempInstructor.getClass());
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			session.close();
			factory.close(); 
		}
		
		

	}

}
