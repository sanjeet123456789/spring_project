package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Instructor;
import com.pal.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			//create the objects
			Instructor tempInstructor=new Instructor("Chad","Darby","sanjeetpal@gmail.com");			//associate the objects
			
			InstructorDetail tempInstructorDetail=new InstructorDetail("https://youtube.com/","coding");
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			//start transaction
			session.beginTransaction();
			
			//save the instructor
			//Note:this will also save the instructor details 
			//because of cascadeTypea.All
			System.out.println("Svaing instructor and Instructor Detail::");
			session.save(tempInstructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			session.close();
			factory.close();
		}
		
		

	}

}
