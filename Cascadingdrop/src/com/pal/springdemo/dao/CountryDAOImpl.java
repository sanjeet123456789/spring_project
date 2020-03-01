package com.pal.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.pal.springdemo.entity.Country;

@Repository("countryDao")
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

	@Override
	public Country find(int id) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Country theCustomer = currentSession.get(Country.class, id);
		System.out.println(theCustomer);
		
		return theCustomer;
		
		
		
		
		
		
		
		
//		Country country=null;
//		Session session=sessionFactory.openSession();
//		Transaction transaction=null;
//		try {
//			transaction =session.beginTransaction();
//			country=(Country)session.createNativeQuery("select s.id as id  from Country s "
//					+ "where id = :id")
//					.setParameter("id", id)
//					.uniqueResult();
//			System.out.println(country);
//			transaction.commit();
//		}catch(Exception e) {
//			country =null;
//			if(transaction!=null) {
//				transaction.rollback();
//			}
//		}finally {
//			session.close();
//		}
//		return country;
	}

	
	
}
