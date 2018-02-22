package com.scp.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.scp.dao.UserDaoImpl;
import com.scp.model.User;
import com.scp.service.ServiceImpl;

@RestController
public class RestControllerDemo {

	@Autowired
	ServiceImpl serviceImpl;

	public ServiceImpl getServiceImpl() {
		return serviceImpl;
	}

	public void setServiceImpl(ServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}

	// checking
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMsg() {
		System.out.println("1 numer");
		return "working fine...!!";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List getList() {
		System.out.println(serviceImpl + "*****************************getList call");
		List lst = serviceImpl.getAll();
		return lst;
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public boolean deleteUser(@PathVariable("id") int id) {
		System.out.println(serviceImpl + "*****************************delete method call");
		return serviceImpl.deleteById(id);
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int id) {
		System.out.println("id is-- " + id);
		System.out.println(serviceImpl + "*****************************getById call");
		return serviceImpl.getUserById(id);
	}
}