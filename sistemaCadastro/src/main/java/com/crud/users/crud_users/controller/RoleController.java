package com.crud.users.crud_users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.users.crud_users.model.Role;
import com.crud.users.crud_users.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService service;
	
	@PostMapping("/create")
	public Role createRole(@RequestBody Role role) {
		service.salvar(role);
		return role;
	}
}
