package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int s_id;
	private int s_name;
	private String course_name;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getS_name() {
		return s_name;
	}
	public void setS_name(int s_name) {
		this.s_name = s_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", course_name=" + course_name + "]";
	}
	
	
}
