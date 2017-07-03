package com.devopps.portal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devopps.portal.model.UserEntity;

@Component("IUserDetailsDao")
public class UserDetailsDaoImpl implements IUserDetailsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(UserEntity userEntity) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(userEntity);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> listUser() {
		Session session = getSessionFactory().openSession();
		List<UserEntity> personList = session.createQuery("from UserEntity").list();
		session.close();
		return personList;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
