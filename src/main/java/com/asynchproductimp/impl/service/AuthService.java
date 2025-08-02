package com.asynchproductimp.impl.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.asynchproductimp.impl.entities.CustomUserDetails;
import com.asynchproductimp.impl.req.AuthRequest;
import com.asynchproductimp.impl.response.AuthResponse;
import com.asynchproductimp.impl.security.JwtUtils;

@Service
public class AuthService {
	
	 private final AuthenticationManager authenticationManager;
	    private final JwtUtils jwtUtils;
	    private final CustomUserDetailsService customUserDetailsService;

	    public AuthService(AuthenticationManager authenticationManager, JwtUtils jwtUtils,
	                       CustomUserDetailsService customUserDetails) {
	        this.authenticationManager = authenticationManager;
	        this.jwtUtils = jwtUtils;
	        this.customUserDetailsService = customUserDetails;
	    }


	    public AuthResponse login(AuthRequest authRequest) {
	        Authentication auth = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
	        );
	
	        CustomUserDetails customUserDetails1 = (CustomUserDetails) auth.getPrincipal();

	        SecurityContextHolder.getContext().setAuthentication(auth);

	        String token = jwtUtils.generateToken(customUserDetails1);
	        AuthResponse authResponse = new AuthResponse(token);

	        return  authResponse;

	    }

}
