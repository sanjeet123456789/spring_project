package com.pal.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pal.springdemo.dao.CityDAO;
import com.pal.springdemo.entity.City;


@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityDAO stateDAO;
	
	@Override
	public List<City> findByState(int stateId) {
		
		
		return stateDAO.findByState(stateId);
	}
}
