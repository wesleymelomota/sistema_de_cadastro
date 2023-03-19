package com.crud.users.crud_users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.users.crud_users.model.Role;
import com.crud.users.crud_users.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository repository;
	
	public void salvar(Role role) {
		repository.save(role);
	}
}
