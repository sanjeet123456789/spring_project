package com.pal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pal.entity.Teachers_t;

@Repository
public class TeachersImpl  implements TeachersDao{
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Teachers_t> getTeachers_ts() {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<Teachers_t> theQuery=currentSession.createQuery("from Teachers_t",Teachers_t.class);
		
		List<Teachers_t> teachers_ts=theQuery.getResultList();
		
		
		return teachers_ts;
	}

	@Override
	public void saveTeachers_t(Teachers_t theTeachers_t) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theTeachers_t);
		
	}

	@Override
	public Teachers_t getTeachers_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Teachers_t theTeachers_t=currentSession.get(Teachers_t.class,theId);
		return theTeachers_t;
		
	}

	@Override
	public void deleteTeachers_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Teachers_t where id=:teachers_tId");
		theQuery.setParameter("teachers_tId", theId);
		theQuery.executeUpdate();
	}
	
	
}
