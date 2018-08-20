package com.synerzip.auth.security.VOs;

import java.io.Serializable;

public class JwtAuthenticationRequestVO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2058279585834565819L;
	private String username;
	private String password;

	public JwtAuthenticationRequestVO() {
		super();
	}

	public JwtAuthenticationRequestVO(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
