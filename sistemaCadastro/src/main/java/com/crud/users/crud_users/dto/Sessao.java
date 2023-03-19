package com.crud.users.crud_users.dto;

public class Sessao {
	
	private String username;
	private String token;
	private Boolean logado;
	
	
	public Boolean getLogado() {
		return logado;
	}
	public void setLogado(Boolean logado) {
		this.logado = logado;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
