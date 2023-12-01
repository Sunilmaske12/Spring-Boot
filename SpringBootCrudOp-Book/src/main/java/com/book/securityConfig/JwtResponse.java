package com.book.securityConfig;

public class JwtResponse {
	
	String jwtToken;
	
	String username;

	public JwtResponse(String token) {
		this.jwtToken = token;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	

}
