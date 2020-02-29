package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		
		Session session=factory.getCurrentSession();
		try {
			int studentId=2;
			System.out.println("saved studnet generated id"+studentId);
			//now get a new session and start a transation
			session=factory.getCurrentSession();
			session.beginTransaction();
			//reterieve student based on the i :primary key
			System.out.println("\n Getting student of "+studentId);
			Student mystudent = session.get(Student.class, studentId);
			session.delete(mystudent);
			System.out.print("deleting complete "+mystudent);
			session.createQuery("delete from Student where id=3").executeUpdate();
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("done");
		}finally {
			session.close();
			factory.close();
		}
		
		

	}

}
