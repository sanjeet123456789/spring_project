package com.pal.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.pal.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;
	
	
	public void addAccount(Account theAccount,boolean vipFLag) {
		System.out.println(getClass()+"\n:Doing my job add account"+theAccount.getName());
	}
	
	public boolean dowork() {
		System.out.println(getClass()+":\nexecuting dowork class");
		return true;
	}

	public String getName() {
		System.out.println(getClass()+":getname");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+":serName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+":getServicecode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+":setServiceCode::");
		this.serviceCode = serviceCode;
	}
	
	
}
