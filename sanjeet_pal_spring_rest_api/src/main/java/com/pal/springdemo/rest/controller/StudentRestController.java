package com.pal.springdemo.rest.controller;
//student rest controller
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pal.springdemo.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define endpoint for "/students" - return list of students
	List<Student> theStudents;
	
	@PostConstruct
	public void loadata() {
theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
	}
	
	
	@GetMapping("/students")
	public List<Student> getStudents() {

			
		System.out.println(theStudents);
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId) {

		//check the studentId agaist the list size
		if ( (studentId >= theStudents.size()) || (studentId < 0) ) {			
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}


		System.out.println(theStudents.get(studentId));
		return theStudents.get(studentId);
	}
	
	//Add an exception handle using @ExceptionHandler
	
	//uncomment if you doesnot want to use global Exception Handler
	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
//		
//		StudentErrorResponse error = new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	 }
//
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//		
//		StudentErrorResponse error = new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}	
//	
	
}





