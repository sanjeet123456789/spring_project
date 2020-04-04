package com.pal.security.jwtspringsecurity.model;

public class JwtUser {
	private String Username;
	private long id;
	private String role;
	public void setUserName(String username ){
		this.Username=username;
		
	}

	public void setId(long id) {
		this.id=id;
		
	}

	public void setRole(String role) {
		this.role=role;
		
	}

	public String getUsername() {
		return Username;
	}

	public long getId() {
		return id;
	}

	public String getRole() {
		return role;
	}
	

}
