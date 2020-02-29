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
import javax.persistence.Table;



@Entity
@Table(name="teachers_t")
public class Teachers_t {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="t_name")
	private String t_Name;
	
	
	@Column(name="teach_id")
	private String teach_Id;
	
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})	
	@JoinTable(
			name="teacher_subject_t",
			joinColumns=@JoinColumn(name="teacher_id"),
			inverseJoinColumns=@JoinColumn(name="subject_id")
			)
	private List<Teachers_t> teachers;
	
	public Teachers_t() {}


//	public Teachers_t(int id, String t_Name, String teach_Id) {
//		super();
//		this.id = id;
//		this.t_Name = t_Name;
//		this.teach_Id = teach_Id;
//	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getT_Name() {
		return t_Name;
	}


	public void setT_Name(String t_Name) {
		this.t_Name = t_Name;
	}


	public String getTeach_Id() {
		return teach_Id;
	}


	public void setTeach_Id(String teach_Id) {
		this.teach_Id = teach_Id;
	}

	

	public List<Teachers_t> getTeachers() {
		return teachers;
	}


	public void setTeachers(List<Teachers_t> teachers) {
		this.teachers = teachers;
	}


	@Override
	public String toString() {
		return "Teachers_t [id=" + id + ", t_Name=" + t_Name + ", teach_Id=" + teach_Id + "]";
	}
	
	
	
}
