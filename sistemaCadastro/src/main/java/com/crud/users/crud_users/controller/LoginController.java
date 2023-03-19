package com.crud.users.crud_users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.users.crud_users.dto.Login;
import com.crud.users.crud_users.dto.Sessao;
import com.crud.users.crud_users.service.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
	@Autowired
	private LoginService service;
	
	@PostMapping
	public Sessao login(@RequestBody Login login) {
		return service.checarLogin(login);
	}
}
