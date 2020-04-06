package com.pal.spring.mysqlauthentication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.pal.spring.mysqlauthentication.model.CustomUserDetail;
import com.pal.spring.mysqlauthentication.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	

	

	Optional<User> findByName(String username); 
	
	

}
