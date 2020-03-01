package com.pal.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pal.springdemo.dao.CountryDao;
import com.pal.springdemo.entity.Country;


@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDao countryDao; 
	
	@Override
	public List<Country> findAll() {
		System.out.println("this is from servicexxxxxxxxxxx");
		return  countryDao.findAll();
	}

}
