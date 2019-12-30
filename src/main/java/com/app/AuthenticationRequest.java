package com.app;

/***
 * this class heps to get an authentication request only in
 * AuthenticationManageClass
 */
public class AuthenticationRequest {
	private String username;
	private String password;

	public AuthenticationRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
