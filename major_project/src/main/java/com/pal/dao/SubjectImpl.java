package com.pal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pal.entity.Subject_t;

@Repository
public class SubjectImpl implements SubjectDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Subject_t> getSubject_ts() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		
		Query<Subject_t> theQuery=currentSession.createQuery("from Subject_t",Subject_t.class);
		
		
		List<Subject_t> subject_ts=theQuery.getResultList();
		
		return subject_ts;
	}

	@Override
	public void saveSubject_t(Subject_t theSubject_t) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theSubject_t);
		
	}

	@Override
	public Subject_t getSubject_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Subject_t theSubject_t=currentSession.get(Subject_t.class,theId);
		
		return theSubject_t;
	}

	@Override
	public void deleteSubject_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Subject_t where id=:subject_tId");
		theQuery.setParameter("subject_tId", theId);
		theQuery.executeUpdate();
		
	}
	
}
