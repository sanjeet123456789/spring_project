package com.pal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="class_t")
public class Class_t {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="class")
	private String class_name;
	
	@Column(name="section")
	private String section;

	
	
	public Class_t() {
		
	}

	public Class_t(int id, String class_name, String section) {
		
		this.id = id;
		this.class_name = class_name;
		this.section = section;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "Class_t [id=" + id + ", class_name=" + class_name + ", section=" + section + "]";
	}
	
	
	
	
}
