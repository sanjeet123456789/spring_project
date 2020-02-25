package com.pal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="class_t_id")
	private List<Subject_t> subjects;
	
	public Class_t() {}
	
	
	
//	public Class_t(int id, String className, String section) {
//		
//		this.id = id;
//		this.className = className;
//		this.section = section;
//	}



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
	

	public List<Subject_t> getSubjects() {
		return subjects;
	}



	public void setSubjects(List<Subject_t> subjects) {
		this.subjects = subjects;
	}



	@Override
	public String toString() {
		return "Class_t [id=" + id + ", className=" + className + ", section=" + section + "]";
	}
	
	
	

}
