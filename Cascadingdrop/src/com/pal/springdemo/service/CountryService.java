package com.pal.springdemo.service;

import java.util.List;

import com.pal.springdemo.entity.Country;

public interface CountryService {
	
	public List<Country> findAll();
	
	public Country find(int id);
	
}
