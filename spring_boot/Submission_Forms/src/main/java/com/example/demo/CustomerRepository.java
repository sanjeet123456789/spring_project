package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//public interface CustomerRepository extends CrudRepository<Customer,Integer>{
//
//	
//}

//For rest API

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
}
