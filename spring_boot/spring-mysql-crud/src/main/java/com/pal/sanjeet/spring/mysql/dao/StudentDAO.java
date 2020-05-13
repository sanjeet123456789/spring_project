package com.pal.sanjeet.spring.mysql.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pal.sanjeet.spring.mysql.model.Student;

public interface StudentDAO extends CrudRepository<Student, Integer> {

	

}
