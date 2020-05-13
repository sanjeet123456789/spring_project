package com.pal.sanjeet.spring.mysql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentlist")
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private String studentName;
	private String course;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", course=" + course + "]";
	}
	public Student(int id, String studentName, String course) {
		
		this.id = id;
		this.studentName = studentName;
		this.course = course;
	}
	public Student() {
		
	}
	
	
	
	
}
