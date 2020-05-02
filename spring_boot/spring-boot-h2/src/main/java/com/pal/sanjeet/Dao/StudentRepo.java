package com.pal.sanjeet.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pal.sanjeet.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>{
	List<Student> findByName(String name);

	List<Student> findBySidGreaterThan(int aid);
	//custom query
	@Query("from Student where name order by sid")
	List<Student> findByNameTypex(String Name);
}
