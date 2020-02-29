package com.pal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pal.entity.Check_busy;
import com.pal.entity.Check_subject;

@Repository
public class Check_busyImpl implements Check_busyDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Check_busy> getCheck_busy_ts() {
		System.out.println("upto");
		Session currentSession=sessionFactory.getCurrentSession();
		System.out.println("asdf");
		Query<Check_busy> theQuery=currentSession.createQuery("from Check_busy",Check_busy.class);
		System.out.println("adsfasd");
		
		
	
		List<Check_busy> class_ts=theQuery.getResultList();
		return class_ts;
	}

	@Override
	public void saveCheck_busy_t(Check_busy theCheck_busy_t) {
	
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCheck_busy_t);
		
	}

	@Override
	public Check_busy getCheck_busy_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Check_busy theCheck_busy_t=currentSession.get(Check_busy.class, theId);
		
		return theCheck_busy_t;
	}

	@Override
	public void deleteCheck_busy_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Check_busy where id=:Check_busyId");
		theQuery.setParameter("Check_busyId", theId);
		theQuery.executeUpdate();
		
	}
	
	

}
