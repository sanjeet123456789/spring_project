package com.pal.sanjeet.spring.multithreading.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pal.sanjeet.spring.multithreading.model.User;
import com.pal.sanjeet.spring.multithreading.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping(value="/users",consumes= {MediaType.MULTIPART_FORM_DATA_VALUE},produces="application/json")
	public ResponseEntity saveusers(@RequestParam(value="files") MultipartFile[] files) throws Exception {
		for(MultipartFile file:files) {
			userservice.saveUser(file);
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@GetMapping(value="/users",produces="application/json")
	public CompletableFuture<ResponseEntity> findusers(){
		return userservice.findAllUsers().thenApply(ResponseEntity::ok);
	}
	
	@GetMapping(value="/multithreadusers",produces="application/json")
	public ResponseEntity getuserslist() {
		CompletableFuture<List<User>> user1=userservice.findAllUsers();
		CompletableFuture<List<User>> user2=userservice.findAllUsers();
		CompletableFuture<List<User>> user3=userservice.findAllUsers();
		CompletableFuture.allOf(user1,user2,user3).join();
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
