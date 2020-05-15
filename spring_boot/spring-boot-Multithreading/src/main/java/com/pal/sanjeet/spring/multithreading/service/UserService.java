package com.pal.sanjeet.spring.multithreading.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pal.sanjeet.spring.multithreading.model.User;
import com.pal.sanjeet.spring.multithreading.respository.UserInfoRepository;

@Service
public class UserService {
	
	@Autowired
	private UserInfoRepository userrepository;
	Logger logger=LoggerFactory.getLogger(UserService.class);
	
	@Async
	public CompletableFuture<List<User>> saveUser(MultipartFile file) throws Exception{
		long start=System.currentTimeMillis();
		List<User> users=parsingCSVFile(file);
		logger.info("saving user {}",users.size()+""+Thread.currentThread().getName());
		users=userrepository.saveAll(users);
		long end=System.currentTimeMillis();
		logger.info("total time{}",end-start);
		return CompletableFuture.completedFuture(users);
	}
	
	@Async
	public CompletableFuture<List<User>> findAllUsers(){
		logger.info("getin list of user{}"+Thread.currentThread().getName());
		List<User> users=userrepository.findAll();
		return CompletableFuture.completedFuture(users);
		
		
	}
	
	
	
	private List<User> parsingCSVFile(final MultipartFile file) throws Exception{
		String line;
		List<User> users=new ArrayList<>();
		try {
			try (final BufferedReader breader=new BufferedReader(new InputStreamReader(file.getInputStream()))){
				while((line=breader.readLine())!=null) {
					final String[] data=line.split(",");
					final User user=new User();
					user.setName(data[0]);
					user.setEmail(data[1]);
					user.setGender(data[2]);
					users.add(user);
				}
				return users;
			}
		}catch(Exception e) {
			throw new Exception("Filed to read file");
		}
		
		
	}
}
