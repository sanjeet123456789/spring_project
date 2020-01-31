package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Course;
import com.pal.hibernate.demo.entity.Instructor;
import com.pal.hibernate.demo.entity.InstructorDetail;
import com.pal.hibernate.demo.entity.Review;
import com.pal.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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
			Course tempCourse=new Course("HOw one on points");
		
			
			
			
			
			System.out.println("saving a course");
			session.save(tempCourse);
			
			//create students
			
			Student tempStudent1=new Student("sanjeet1","pal1","sanjeetpal12345@ggmaoil.com");
			Student tempStudent2=new Student("cello1","pen1","cellopen@gmai.com");
			
			//add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the students
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("saving the student:"+tempStudent1+""+tempStudent2);
			
			
			
			
			
			
			
			
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
