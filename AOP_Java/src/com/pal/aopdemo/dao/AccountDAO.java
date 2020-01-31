package com.pal.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.pal.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount,boolean vipFLag) {
		System.out.println(getClass()+"\n:Doing my job add account"+theAccount.getName());
	}
	
	public boolean dowork() {
		System.out.println(getClass()+":\nexecuting dowork class");
		return true;
	}
}
