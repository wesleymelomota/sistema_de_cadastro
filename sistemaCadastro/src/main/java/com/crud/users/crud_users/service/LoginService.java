package com.crud.users.crud_users.service;




import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.users.crud_users.config.SecurityConfig;
import com.crud.users.crud_users.dto.Login;
import com.crud.users.crud_users.dto.Sessao;
import com.crud.users.crud_users.model.UserModel;
import com.crud.users.crud_users.repository.UserRepository;
import com.crud.users.crud_users.security.JwtCreator;
import com.crud.users.crud_users.security.JwtObject;

import jakarta.websocket.Encoder;

@Service
public class LoginService {
	@Autowired
	private UserRepository userRepo;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public Sessao checarLogin(Login login) {
		UserModel user = userRepo.findByusername(login.getUsername());
		if(user != null) {
			Boolean passOk = encoder.matches(login.getPassword(), user.getPassword());
			if(!passOk) {
				throw new RuntimeException("Erro! senha ou usuario invalido");
			}
			JwtObject jwt = new JwtObject();
			Sessao sessao = new Sessao();
			sessao.setUsername(user.getUsername());
			
			jwt.setSubject(user.getUsername());
			jwt.setIssuetAT(new Date(System.currentTimeMillis()));
			jwt.setExpiration(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION));
			jwt.setRoles(user.getRoleStr());
			sessao.setLogado(true);
			sessao.setToken(JwtCreator.create(SecurityConfig.PREFIX, SecurityConfig.getKey(), jwt));
			return sessao;
		}else {
			throw new RuntimeException("ERRO! não foi possivel logar");
		}
	}
}
