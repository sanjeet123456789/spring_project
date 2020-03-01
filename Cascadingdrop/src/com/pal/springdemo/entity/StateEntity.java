package com.pal.springdemo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="State")
public class StateEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String state_name;
	
	
	@Column(name="country_id")
	private int country_id;

	

	
	public StateEntity() {}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}









	public String getState_name() {
		return state_name;
	}





	public void setState_name(String state_name) {
		this.state_name = state_name;
	}




	




	public int getCountry_id() {
		return country_id;
	}





	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}





	@Override
	public String toString() {
		return "State [id=" + id + ", state_name=" + state_name + ", country_id=" + country_id + "]";
	}






	







	
	
	


	
	

}
