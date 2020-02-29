package com.pal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Check_subject")
public class Check_subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="class_section")
	private String class_Section;
	
	
	@Column(name="subject_name")
	private String subject_Name;
	
	@Column(name="teachers_id")
	private int teachers_Id;
	
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="teachers_id")
//	private Teachers_t teachers_Id;
	
	
//	
////	@OneToOne(cascade=CascadeType.ALL)
////	@JoinColumn(name="teachers_id")
////	private Teachers_t teachers_Id;
	
	
	public Check_subject() {}

//	public Check_subject(int id, String class_Section, String subject_Name, int teachers_Id) {
//		this.id = id;
//		this.class_Section = class_Section;
//		this.subject_Name = subject_Name;
//		this.teachers_Id = teachers_Id;
////		this.teachers_t=teachers_t;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClass_Section() {
		return class_Section;
	}

	public void setClass_Section(String class_Section) {
		this.class_Section = class_Section;
	}

	public String getSubject_Name() {
		return subject_Name;
	}

	public void setSubject_Name(String subject_Name) {
		this.subject_Name = subject_Name;
	}

	
	
	


//	public Teachers_t getTeachers_Id() {
//		return teachers_Id;
//	}
//
//	public void setTeachers_Id(Teachers_t teachers_Id) {
//		this.teachers_Id = teachers_Id;
//	}

	public int getTeachers_Id() {
		return teachers_Id;
	}

	public void setTeachers_Id(int teachers_Id) {
		this.teachers_Id = teachers_Id;
	}

	@Override
	public String toString() {
		return "Check_subject_t [id=" + id + ", class_Section=" + class_Section + ", subject_Name=" + subject_Name
				+ ", teachers_Id=" + teachers_Id + "]";
	}


	
	
}
