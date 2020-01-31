package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.pal.hibernate.demo.entity.Course;
import com.pal.hibernate.demo.entity.Instructor;
import com.pal.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			//option:2 hibernate quey with hql
			//get the instructor from DB
			int theId=1;
			Query<Instructor> query=session.createQuery("select i from  Instructor i "
					+"JOIN FETCH i.courses "
					+"where i.id=:theInstructorId",
					Instructor.class);
			//set parameter on query
			query.setParameter("theInstructorId", theId);
			
			//execute query and get instructor
			Instructor tempInstructor=query.getSingleResult();
			System.out.println("sanjeet palinstructor name:"+tempInstructor.getFirstName()+" "+tempInstructor.getLastName());
			
			//commit transaction
			session.getTransaction().commit();
			//session.close()
			System.out.print("closing the session");
			session.close();
			//option1:call the getter method when session is open
			System.out.println("dsanjeet"+tempInstructor.getCourses());
			
			System.out.println("pal:done");
		}finally {
			
			factory.close(); 
		}
		
		

	}

}
