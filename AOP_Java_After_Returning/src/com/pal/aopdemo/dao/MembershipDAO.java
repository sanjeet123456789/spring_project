package com.pal.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addAccount() {
		System.out.println(getClass()+":Doinf a member hship Account");
		return true;
	}
	
	public void sleeping() {
		System.out.println(getClass()+"\n going to slepp");
	}
}
