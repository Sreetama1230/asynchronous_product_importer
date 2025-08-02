package com.asynchproductimp.impl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asynchproductimp.impl.entities.User;
import com.asynchproductimp.impl.service.UserService;

@RestController
@RequestMapping("/register")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<Long> register( @RequestBody User u) {
		return new ResponseEntity<Long>(service.register(u), HttpStatus.CREATED);

	}
}
