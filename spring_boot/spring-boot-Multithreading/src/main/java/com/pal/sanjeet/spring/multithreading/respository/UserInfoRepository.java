package com.pal.sanjeet.spring.multithreading.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pal.sanjeet.spring.multithreading.model.User;

public interface UserInfoRepository extends JpaRepository<User,Integer>{

}
