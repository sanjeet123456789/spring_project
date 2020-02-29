package com.pal.hibernate.demo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		
		Session session=factory.getCurrentSession();
		try {
			
			//start a trancation
			session.beginTransaction();
			//query student
			List<Student> theStudent=session.createQuery("from Student").list();
			displayStudent(theStudent);
			
			//query student lastname ="pal"
			
			theStudent=session.createQuery("from Student s where s.lastName='pal'").list();
			System.out.print("studnet with last laname");
			displayStudent(theStudent);
			
			
			
			//query student lastNmae="dowe" or firstName="doe
			theStudent=session.createQuery("from Student s where "+
						"s.lastName='pal' OR s.firstName='pal'").list();
			displayStudent(theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			factory.close();
		}
		
		

	}

	private static void displayStudent(List<Student> theStudent) {
		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
			
		}
	}

}
