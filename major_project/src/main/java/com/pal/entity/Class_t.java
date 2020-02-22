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
	private String className;
	
	@Column(name="section")
	private String section;
	
	public Class_t() {}
	
	
	
	public Class_t(int id, String className, String section) {
		
		this.id = id;
		this.className = className;
		this.section = section;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "Class_t [id=" + id + ", className=" + className + ", section=" + section + "]";
	}
	
	
	

}
