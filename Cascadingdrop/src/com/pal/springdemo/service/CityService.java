package com.pal.springdemo.service;

import java.util.List;

import com.pal.springdemo.entity.City;

public interface CityService {
	public List<City> findByState(int stateId);
}
