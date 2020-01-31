package com.pal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pal.hibernate.demo.entity.Course;
import com.pal.hibernate.demo.entity.Instructor;
import com.pal.hibernate.demo.entity.InstructorDetail;
import com.pal.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		//create session factory
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create session
		
		Session session=factory.getCurrentSession();
		try {
	
			
			//start transaction
			session.beginTransaction();
			Course tempCourse=new Course("HOw to score one million points");
			//create a course
			//add some review
			tempCourse.addReview(new Review("Great course i love it"));
			tempCourse.addReview(new Review("Great course tank you"));
			tempCourse.addReview(new Review("Great course +1"));
			tempCourse.addReview(new Review("Great course love it"));
			tempCourse.addReview(new Review("not so goood..>3"));
			//save the course and leverage the code
			System.out.println("saving  the course");
			session.save(tempCourse);
			
			
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
