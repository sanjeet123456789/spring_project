package com.pal.springdemo.dao;

import java.util.List;

import com.pal.springdemo.entity.Country;

public interface CountryDao {
	
	public List<Country> findAll();
}
