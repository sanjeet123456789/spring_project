package com.pal.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Country")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String country_name;
	

	

	
	public Country() {}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getCountry_name() {
		return country_name;
	}





	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}





	@Override
	public String toString() {
		return "Country_e [id=" + id + ", country_name=" + country_name + "]";
	}
	
	
	


	
	

}
