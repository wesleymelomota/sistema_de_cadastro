package com.crud.users.crud_users.dto;

import org.springframework.beans.BeanUtils;

import com.crud.users.crud_users.model.Cliente;

public class ClienteDto {
	
	private String nome;
	private Integer idade;
	
	public ClienteDto convert(Cliente cliente) {
		BeanUtils.copyProperties(cliente, this, "logradoro", "email", "cell");
		return this;
	}
}
