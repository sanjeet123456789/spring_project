package com.pal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pal.entity.Teacher_subject_t;
@Repository
public class Teacher_subjectImpl implements Teacher_subjectDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Teacher_subject_t> getTeacher_subject_ts() {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Teacher_subject_t> theQuery=currentSession.createQuery("from Teacher_subject_t",Teacher_subject_t.class);
		
		List<Teacher_subject_t>  teacher_subject_t=theQuery.getResultList();
		return teacher_subject_t;
	}

	@Override
	public void saveTeacher_subject_t(Teacher_subject_t theTeacher_subject_t) {
		Session currentSession=sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theTeacher_subject_t);
		
	}

	@Override
	public Teacher_subject_t getTeacher_subject_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Teacher_subject_t theTeacher_subject_t=currentSession.get(Teacher_subject_t.class, theId);
		
		return theTeacher_subject_t;
	}

	@Override
	public void deleteTeacher_subject_t(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Teacher_subject_t where id=:teacher_subject_tId");
		theQuery.setParameter("teacher_subject_tId", theId);
		theQuery.executeUpdate();
	}

}
