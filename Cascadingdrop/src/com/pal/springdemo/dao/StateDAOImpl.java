package com.pal.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pal.springdemo.entity.Country;
import com.pal.springdemo.entity.StateEntity;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;


@Repository("stateDAO")
public class StateDAOImpl implements StateDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<StateEntity> findByCountry(int CountryId) {
	Session currentSession = sessionFactory.getCurrentSession();
			
			// now retrieve/read from database using the primary key
	
	Query<StateEntity> theQuery = 
			currentSession.createQuery("from StateEntity where country_id = :CountryId",
										StateEntity.class);
	theQuery.setParameter("CountryId", CountryId);
	
	// execute query and get result list
	List<StateEntity> customers = theQuery.getResultList();
	System.out.println(customers);
			
		
		return customers;
		
		
		
////		List<StateEntity> stateEntities=null;
//		List<StateEntity> customers=null;
//		Session session=sessionFactory.openSession();
//		Transaction transaction=null;
//		try {
//			transaction =session.beginTransaction();
////			stateEntities=session.createQuery("select s.id as id ,"
////					+ "s.name as name "
////					+ "from state "
////					+ "where country_id= "+CountryId)
////					.setInteger("CountryId", CountryId)
////					.setResultTransformer(Transformers.aliasToBean(StateEntity.class)).list();
////			transaction.commit();
//		}catch(Exception e) { 
//			customers=null;
//			if(transaction!=null) {
//				transaction.rollback();
//			}
//		}finally {
//			session.close();
//		}
//		return customers;
	}

}
