package com.pal.springdemo.dao;

import java.util.List;

import com.pal.springdemo.entity.City;

public interface CityDAO {
	public List<City> findByState(int StateId);
}
