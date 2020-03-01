package com.pal.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pal.springdemo.entity.Country;

@Repository("CountryDao")
public class CountryDAOImpl implements CountryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Country> findAll() {
		System.out.println("xxxx");
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("xxxx");
		// create a query
		Query<Country> theQuery = 
				currentSession.createQuery("from Country", Country.class);
		System.out.println("xxx");
		// execute query and get result list
		List<Country> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	
	
}
