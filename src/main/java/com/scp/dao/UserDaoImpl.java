package com.scp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scp.model.User;

//@Repository
@Repository("daoImpl")
public class UserDaoImpl {
	
	@Autowired
	public SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		System.out.println("setting factory.."+factory);
		this.factory = factory;
	}

	public List getAll() {
		System.out.println("In Dao Layer- "+factory);
		Session session = factory.openSession();
		List list = session.createQuery("from User").list();
		session.close();
		return list;
	}

	public boolean deleteById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, id);
		session.delete(user);
		tx.commit();
		session.close();
		return true;
	}
	
	public User getUserById(int id) {
		Session session = factory.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}
	
	public boolean addUser(User u) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(u);
		transaction.commit();
		session.close();
		return true;
	}
}