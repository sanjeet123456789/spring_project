package com.pal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pal.entity.Check_subject;
import com.pal.entity.Class_t;

@Repository
public class Check_subjectImpl implements Check_subjectDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Check_subject> getCheck_subject_ts() {
		Session currentSession=sessionFactory.getCurrentSession();
		System.out.println("asdf");
		Query<Check_subject> theQuery=currentSession.createQuery("from Check_subject",Check_subject.class);
		System.out.println("adsfasd");
		
		List<Check_subject> class_ts=theQuery.getResultList();
		return class_ts;
	}

	@Override
	public void saveCheck_subject_t(Check_subject theCheck_subject_t) {
	
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCheck_subject_t);
		
	}

	@Override
	public Check_subject getCheck_Subject_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Check_subject theCheck_subject_t=currentSession.get(Check_subject.class, theId);
		
		return theCheck_subject_t;
	}

	@Override
	public void deleteCheck_subject_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Check_subject where id=:Check_subjectId");
		theQuery.setParameter("Check_subjectId", theId);
		theQuery.executeUpdate();
		
	}
	
	

}
