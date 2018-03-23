package com.marcin.product.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.product.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> listUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from app_user order by app_username");
		List<User> usersList = theQuery.getResultList();
		return usersList;
	}

	@Override
	public void addUser(User theUser) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate("addUser", theUser);
	}

}
