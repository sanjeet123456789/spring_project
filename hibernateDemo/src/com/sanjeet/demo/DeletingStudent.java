package com.sanjeet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;
import com.hibernate.Entity.Review;
import com.hibernate.Entity.Student;

public class DeletingStudent {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
	
			
			//start transaction
			session.beginTransaction();
			//get the student mary  from database
			int studentId=3;
			Student tempStudent=session.get(Student.class, studentId);
			System.out.println("\n loaded mary info"+tempStudent.getLastName());
			//create more courses
			System.out.println("courses for cello:"+tempStudent.getCourses());
			System.out.println("Deleting Student...."+tempStudent.getFirstName());
			session.delete(tempStudent);
			
			
			//commit transaction
			System.out.println("transcatiopnin process");
			session.getTransaction().commit();
			System.out.println("done");
		}finally {
			session.close();
			factory.close();
		}
	}
}
