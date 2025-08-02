package com.asynchproductimp.impl.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asynchproductimp.impl.req.AuthRequest;
import com.asynchproductimp.impl.response.AuthResponse;
import com.asynchproductimp.impl.service.AuthService;

@RestController
@RequestMapping("/login")
public class AuthController {
	
	@Autowired
	private AuthService  service;
	
	@PostMapping
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest  request){
		return new ResponseEntity<AuthResponse>(service.login(request),HttpStatus.CREATED);
	}

}
