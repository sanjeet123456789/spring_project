package com.pal.sanjeet.basics;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Reservation {
	@Id
	private String uid;
	private String name;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Reservation(String uid, String name) {
		this.uid = uid;
		this.name = name;
	}
	public Reservation() {
	}
	
	
}
