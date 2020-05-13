package com.pal.sanjeet.spring.mysql.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pal.sanjeet.spring.mysql.dao.StudentDAO;
import com.pal.sanjeet.spring.mysql.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@PostMapping("/add")
	public String addStudent(@RequestBody List<Student> student) {
		studentDAO.saveAll(student);
		return "student added succssfully";
		
	}
	@GetMapping("/all")
	public List<Student> getStudents(){
		return (List<Student>)studentDAO.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Student> getstudent(@PathVariable int id){
		return studentDAO.findById(id);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentDAO.deleteById(id);
		return "student deleted successfully";
	}
	
	
	
}
