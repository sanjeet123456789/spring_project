package com.sanjeet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;
import com.hibernate.Entity.Review;
import com.hibernate.Entity.Student;



public class AddCourseForstudent3 {

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
			Course cr=new Course("writindfstdsfdsf blog");
			Course cr2=new Course("writidsfngdfsdfs SA");
			
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
