package com.pal.sanjeet.spring.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pal.sanjeet.spring.mongodb.model.Student;
import com.pal.sanjeet.spring.mongodb.service.StudentRepository;
import org.bson.types.ObjectId;
@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository repository;
	
	
	@PostMapping("/student/add")
	public String saveStudent(@RequestBody Student student) {
		repository.save(student);
		return "student added successfully";
	}
	
	@GetMapping("/all")
	public List<Student> getStudent(){
		return repository.findAll();
	}
	@GetMapping("/student/{id}")
	public Optional<Student> getstudent(@PathVariable int id){
		return repository.findById(id);
	}
	@DeleteMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		repository.deleteById(id);
		return "student deleted successfully";
	}
	
}
