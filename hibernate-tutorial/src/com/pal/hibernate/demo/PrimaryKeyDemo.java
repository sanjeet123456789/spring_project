package com.pal.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.pal.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			
			
			//create 3 student  student objects
			System.out.print("Creating a new student object");
			Student tempStudent1=new Student("sanjeet","pal","pal@gmail.com");
			Student tempStudent2=new Student("sagar","negi","sagarpal@gmail.com");
			Student tempStudent3=new Student("amarjeet","rajpal","rajpal@gmail.com");
		
			
			//start a tranction
			session.beginTransaction();
			
			

			//save the student object
			System.out.println("saving the object");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			session.close();
			factory.close();
		}
		

	}

}
