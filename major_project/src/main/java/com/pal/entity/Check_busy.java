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
@Table(name="Check_busy")
public class Check_busy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="day")
	private String day_Name;
	
	@Column(name="period")
	private String period_Name;
	
	@Column(name="teachers_id")
	private int Teachers_Id;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="teachers_id")
//	private Teachers_t Teachers_Id;
	

	
	public Check_busy() {}


//	public Check_busy(int id, String day_Name, String period_Name, int teachers_Id) {
//		this.id = id;
//		this.day_Name = day_Name;
//		this.period_Name = period_Name;
//		Teachers_Id = teachers_Id;
//	
//	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDay_Name() {
		return day_Name;
	}


	public void setDay_Name(String day_Name) {
		this.day_Name = day_Name;
	}


	public String getPeriod_Name() {
		return period_Name;
	}


	public void setPeriod_Name(String period_Name) {
		this.period_Name = period_Name;
	}


	public int getTeachers_Id() {
		return Teachers_Id;
	}


	public void setTeachers_Id(int teachers_Id) {
		Teachers_Id = teachers_Id;
	}
	
	




	@Override
	public String toString() {
		return "Check_busy [id=" + id + ", day_Name=" + day_Name + ", period_Name=" + period_Name + ", Teachers_Id="
				+ Teachers_Id + "]";
	}


//	public Teachers_t getTeachers_Id() {
//		return Teachers_Id;
//	}
//
//
//	public void setTeachers_Id(Teachers_t teachers_Id) {
//		this.Teachers_Id = teachers_Id;
//	}
//	
	
	

}
