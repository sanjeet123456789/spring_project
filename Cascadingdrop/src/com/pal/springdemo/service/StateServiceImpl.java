package com.pal.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pal.springdemo.dao.StateDAO;
import com.pal.springdemo.entity.StateEntity;


@Service("stateService")
@Transactional
public class StateServiceImpl implements StateService{
	
	@Autowired
	private StateDAO stateDAO;
	
	@Override
	public List<StateEntity> findByCountry(int countryId) {
		
		
		return stateDAO.findByCountry(countryId);
	}
		
}
