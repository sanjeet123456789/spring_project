package com.pal.spring.mysqlauthentication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pal.spring.mysqlauthentication.model.CustomUserDetail;
import com.pal.spring.mysqlauthentication.model.User;
import com.pal.spring.mysqlauthentication.repository.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService{
	//userDetails is an interface so we have to create model for it
	
	@Autowired
	private UserRepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Optional<User> optionaluser=userrepository.findByName(username); 
//			User users=userrepository.findByName(username);
			optionaluser
				.orElseThrow(()-> new UsernameNotFoundException("username not found"));
			
			return optionaluser
					.map(CustomUserDetail::new).get();


	}
	
	

}
