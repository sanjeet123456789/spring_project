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
@Table(name="city")
public class City {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String city_name;
	
	
	@Column(name="state_id")
	private int state_id;

	

	
	public City() {}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}




	public String getCity_name() {
		return city_name;
	}





	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}





	public int getState_id() {
		return state_id;
	}





	public void setState_id(int state_id) {
		this.state_id = state_id;
	}





	@Override
	public String toString() {
		return "City [id=" + id + ", city_name=" + city_name + ", state_id=" + state_id + "]";
	}



	

}
