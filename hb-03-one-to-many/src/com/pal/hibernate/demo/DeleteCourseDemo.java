package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Course;
import com.pal.hibernate.demo.entity.Instructor;
import com.pal.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
			//get a course
			int theId=10;
			Course tempCourse=session.get(Course.class,theId);
			//delete course
			session.delete(tempCourse);
			System.out.println("delting course is "+tempCourse.getTitle());
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			session.close();
			factory.close(); 
		}
		
		

	}

}
