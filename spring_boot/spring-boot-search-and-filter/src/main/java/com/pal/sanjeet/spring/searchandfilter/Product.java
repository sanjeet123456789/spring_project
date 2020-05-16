package com.pal.sanjeet.spring.searchandfilter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
create or replace table product( id BIGINT AUTO_INCREMENT, name varchar(255) not null, brand varchar(255) not null, madein varchar(255) not null, price float(5), primary key(id));


*/
@Entity
public class Product {
	private Long id;
	private String name;
	private String brand;
	private String madein;
	private float price;

	protected Product() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMadein() {
		return madein;
	}

	public void setMadein(String madein) {
		this.madein = madein;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
