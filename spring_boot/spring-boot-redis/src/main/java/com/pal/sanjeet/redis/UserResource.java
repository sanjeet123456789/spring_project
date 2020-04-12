package com.pal.sanjeet.redis;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserResource {
	
	private UserRepository userRespository;

	public UserResource(UserRepository userRespository) {
		this.userRespository = userRespository;
	}
	
	@GetMapping("/add/{id}/{name}")
	public User addUser(@PathVariable("id") final String id,
			@PathVariable("name") final String name) {
		userRespository.save(new User(id,name,200L));
		return userRespository.findById(id);
	}
	@GetMapping("/update/{id}/{name}")
	public User updateUser(@PathVariable("id") final String id,
			@PathVariable("name") final String name) {
		userRespository.update(new User(id,name,200L));
		return userRespository.findById(id);
	}
	@GetMapping("/all")
	public Map<String,User> allUser() {
		
		return userRespository.findAll();
	}
	
	@GetMapping("/delete/{id}")
	public Map<String, User> addUser(@PathVariable("id") final String id) {
		userRespository.delete(id);
		return userRespository.findAll();
	}
	
	
}
