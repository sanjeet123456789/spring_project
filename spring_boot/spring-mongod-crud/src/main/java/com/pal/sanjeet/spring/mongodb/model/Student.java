package com.pal.sanjeet.spring.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
/*
    "timestamp": "2020-05-13T01:55:01.509+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "No converter found capable of converting from type [org.bson.types.ObjectId] to type [int]",
    "path": "/all"
*/
@Document(collection="studentlist")
public class Student {
	//@Id ObjectId databaseId;
	@Id
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
	
	
	
}
