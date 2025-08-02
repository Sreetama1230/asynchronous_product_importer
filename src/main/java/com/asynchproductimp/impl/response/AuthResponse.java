package com.asynchproductimp.impl.response;

public class AuthResponse {
	 private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResponse(String token) {
		super();
		this.token = token;
	}
	 
	 
}
