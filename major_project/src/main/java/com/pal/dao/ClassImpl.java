package com.pal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pal.entity.Class_t;


@Repository
public class ClassImpl implements ClassDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Class_t> getClass_ts() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Class_t> theQuery=currentSession.createQuery("from Class_t",Class_t.class);
		
		
		List<Class_t> class_ts=theQuery.getResultList();
		return class_ts;
	}

	@Override
	public void saveClass_t(Class_t theClass_t) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theClass_t);
	}

	@Override
	public Class_t getClass_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Class_t theClass_t=currentSession.get(Class_t.class, theId);
		return theClass_t;
	}

	@Override
	public void deleteClass_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Class_t where id=:class_tId");
		theQuery.setParameter("class_tId", theId);
		theQuery.executeUpdate();
		
	}
	
	

}
