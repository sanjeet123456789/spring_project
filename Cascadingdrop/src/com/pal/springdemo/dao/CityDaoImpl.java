package com.pal.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pal.springdemo.entity.City;


@Repository("cityDAO")
public class CityDaoImpl implements CityDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<City> findByState(int StateId) {
	Session currentSession = sessionFactory.getCurrentSession();
			
			// now retrieve/read from database using the primary key
	
	Query<City> theQuery = 
			currentSession.createQuery("from City where state_id = :StateId",
										City.class);
	theQuery.setParameter("StateId", StateId);
	
	// execute query and get result list
	List<City> customers = theQuery.getResultList();
	System.out.println(customers);
			
		
		return customers;

	}

}
