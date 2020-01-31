package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Course;
import com.pal.hibernate.demo.entity.Instructor;
import com.pal.hibernate.demo.entity.InstructorDetail;
import com.pal.hibernate.demo.entity.Review;
import com.pal.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		
		Session session=factory.getCurrentSession();
		try {
	
			
			//start transaction
			session.beginTransaction();
			//get the student mary  from database
			int studentId=3;
			Student tempStudent=session.get(Student.class, studentId);
			System.out.println("\n loaded mary info"+tempStudent.getLastName());
			//create more courses
			Course cr=new Course("writindfstdsf blog");
			Course cr2=new Course("writidsfngdfs SA");
			
			//add student to  the courses
			cr.addStudent(tempStudent);
			cr2.addStudent(tempStudent);
			//save the course
			System.out.println("Saving teh courses.."+cr+" "+cr2);
			session.save(cr);
			session.save(cr2);
			
			
			
			
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
