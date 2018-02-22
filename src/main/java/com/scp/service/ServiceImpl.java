package com.scp.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scp.dao.UserDaoImpl;
import com.scp.model.User;

//@Transactional
@Service("serviceImpl")
//@Service
public class ServiceImpl 
{
	
	@Autowired
	UserDaoImpl daoImpl;
	
	public UserDaoImpl getDaoImpl() {
		return daoImpl;
	}

	public void setDaoImpl(UserDaoImpl daoImpl) {
		this.daoImpl = daoImpl;
	}
	
	public List getAll() {
		System.out.println("in service layer*************");
		return daoImpl.getAll();
	}

	public boolean deleteById(int id) {

		return daoImpl.deleteById(id);
	}
	
	public User getUserById(int id) {
	
		return daoImpl.getUserById(id);
	}
	/*
	public boolean addUser(User user) {
		
		return daoImpl.addUser(user); 
	}*/
}
