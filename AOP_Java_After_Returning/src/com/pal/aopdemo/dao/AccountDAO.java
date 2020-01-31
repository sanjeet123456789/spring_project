package com.pal.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pal.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;
	
	//add a new method :findAccounts()
	public List<Account> findAccounts(){
		List<Account> myAccounts=new ArrayList<>();
		//create sample accounts
		Account temp1=new Account("sanjeet","platinum");
		Account temp2=new Account("Amardeep","gold");
		Account temp3=new Account("Luca","Silver");
		
		//add them to our account list
		myAccounts.add(temp3);
		myAccounts.add(temp2);
		myAccounts.add(temp1);
		
		
		
		return myAccounts;
	}
	
	
	
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
