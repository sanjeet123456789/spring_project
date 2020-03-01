package com.pal.springdemo.dao;

import java.util.List;

import com.pal.springdemo.entity.StateEntity;

public interface StateDAO {
	
	public List<StateEntity> findByCountry(int CountryId);

}
