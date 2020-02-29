package com.pal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher_subject_t")
public class Teacher_subject_t {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="teacher_id")
	private int teacher_Id;
	
	
	@Column(name="subject_id")
	private int subject_id;
	
	
	public Teacher_subject_t() {}


//	public Teacher_subject_t(int id, int teacher_Id, int subject_id) {
//		super();
//		this.id = id;
//		this.teacher_Id = teacher_Id;
//		this.subject_id = subject_id;
//	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTeacher_Id() {
		return teacher_Id;
	}


	public void setTeacher_Id(int teacher_Id) {
		this.teacher_Id = teacher_Id;
	}


	public int getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}


	@Override
	public String toString() {
		return "Teacher_subject_t [id=" + id + ", teacher_Id=" + teacher_Id + ", subject_id=" + subject_id + "]";
	}
	
	
	
	

}
