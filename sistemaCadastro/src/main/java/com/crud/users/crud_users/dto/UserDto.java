package com.crud.users.crud_users.dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.crud.users.crud_users.model.Role;
import com.crud.users.crud_users.model.UserModel;

public class UserDto {
	private Integer id;
	private String name;
	private String username;
	private List<Role> role;
	
	public UserDto convert(UserModel user) {
		BeanUtils.copyProperties(user, this, "password");
		return this;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}
	
	
}
