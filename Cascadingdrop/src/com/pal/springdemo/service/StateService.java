package com.pal.springdemo.service;

import java.util.List;

import com.pal.springdemo.entity.StateEntity;

public interface StateService {
	public List<StateEntity> findByCountry(int countryId);
}
