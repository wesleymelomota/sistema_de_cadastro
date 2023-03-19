package com.crud.users.crud_users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.users.crud_users.dto.ClienteDto;
import com.crud.users.crud_users.dto.UserDto;
import com.crud.users.crud_users.model.Cliente;
import com.crud.users.crud_users.model.UserModel;
import com.crud.users.crud_users.service.ClienteService;
import com.crud.users.crud_users.service.UserService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService service;
	@Autowired
	ClienteService serviceCli;
	
	@PostMapping
	public UserDto createUser(@RequestBody UserModel user) {
		return service.salvar(user);
	}
	
	@GetMapping
	public List<UserModel> helloUser() {
		return service.obterTodos();
	}
	@GetMapping("/user-pag")
	public String userPag() {
		return "Bem-vindo! usuario autorizado";
	}
	
}
