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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject_t")
public class Subject_t {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	
	@Column(name="subject_name")
	private String Subject_Name;
	
	@Column(name="s_class")
	private String s_Class;
	
	
	@Column(name="total_in_week")
	private int total_in_Week;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})	
	@JoinTable(
			name="teacher_subject_t",
			joinColumns=@JoinColumn(name="subject_id"),
			inverseJoinColumns=@JoinColumn(name="teacher_id")
			)
	private List<Teachers_t> teachers;
	
	
	
//	
//	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
//			CascadeType.DETACH,CascadeType.REFRESH})
//	@JoinColumn(name="s_class")
//	private Class_t class_t_obj;
//	
	public Subject_t() {}
	
	
	

//	public Subject_t(int id, String subject_Name, String s_Class, int total_in_Week) {
////		super();
//		this.id = id;
//		Subject_Name = subject_Name;
//		this.s_Class = s_Class;
//		this.total_in_Week = total_in_Week;
//	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject_Name() {
		return Subject_Name;
	}

	public void setSubject_Name(String subject_Name) {
		Subject_Name = subject_Name;
	}

	public String getS_Class() {
		return s_Class;
	}

	public void setS_Class(String s_Class) {
		this.s_Class = s_Class;
	}

	public int getTotal_in_Week() {
		return total_in_Week;
	}

	public void setTotal_in_Week(int total_in_Week) {
		this.total_in_Week = total_in_Week;
	}

//	
//	public Class_t getClass_t_obj() {
//		return class_t_obj;
//	}
//
//
//
//
//	public void setClass_t_obj(Class_t class_t_obj) {
//		this.class_t_obj = class_t_obj;
//	}

	
	



	@Override
	public String toString() {
		return "Subject_t [id=" + id + ", Subject_Name=" + Subject_Name + ", s_Class=" + s_Class + ", total_in_Week="
				+ total_in_Week + "]";
	}




	public List<Teachers_t> getTeachers() {
		return teachers;
	}




	public void setTeachers(List<Teachers_t> teachers) {
		this.teachers = teachers;
	}
	
	
	
	
}
