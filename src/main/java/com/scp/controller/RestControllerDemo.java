package com.scp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scp.dao.UserDaoImpl;
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
	public String getMsg(HttpServletRequest request) {
		System.out.println("1 numer");
		return "working fine...!!";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List getList() {
		System.out.println(serviceImpl+"*****************************aabbcc");
		List lst = serviceImpl.getAll();
		return lst;
	}
}