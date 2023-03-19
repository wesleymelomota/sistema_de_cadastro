package com.crud.users.crud_users.security;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.crud.users.crud_users.model.Role;

public class JwtObject {
	
	private String subject;
	private Date issuetAT;
	private Date expiration;
	private List<String> roles;
	
	public List<String> setRole(String... roles){
		return Arrays.asList(roles);
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getIssuetAT() {
		return issuetAT;
	}
	public void setIssuetAT(Date issuetAT) {
		this.issuetAT = issuetAT;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
}
