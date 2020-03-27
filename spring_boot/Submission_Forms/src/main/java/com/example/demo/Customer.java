package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private int c_id;
	private String c_name;
	private String c_email;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_email() {
		return c_email;
	}
	public void setC_email(String c_email) {
		this.c_email = c_email;
	}
	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", c_email=" + c_email + "]";
	}
	
	

}
