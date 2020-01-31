package com.sanjeet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;
import com.hibernate.Entity.Review;
import com.hibernate.Entity.Student;

public class GetCoursesOfStudent {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session  session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			int studentId=1;
			
			Student student=session.get(Student.class,studentId);
			System.out.println(student.getCourses());
			session.getTransaction().commit();
			System.out.println("done");
			
			
		}finally {
			session.close();
			factory.close();
		}
		
		
		
		
	}
}
