package com.asynchproductimp.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asynchproductimp.impl.dao.UserDao;
import com.asynchproductimp.impl.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Long register(User u) {
		u.setPassword(  passwordEncoder.encode(u.getPassword()));
		User savedUser = dao.save(u);
		return savedUser.getId();
	}
	
	
}
