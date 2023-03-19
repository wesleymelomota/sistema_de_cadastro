package com.crud.users.crud_users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.users.crud_users.dto.ClienteDto;
import com.crud.users.crud_users.model.Cliente;
import com.crud.users.crud_users.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	
	public ClienteDto salvar(Cliente cliente) {
		ClienteDto clienteDto = new ClienteDto();
		repository.save(cliente);
		return clienteDto.convert(cliente);
	}
	public List<Cliente> obterTodos(){
		return repository.findAll();
	}
	 
	public void deletar(Integer id) {
		repository.deleteById(id);
	}
	public Cliente getCliente(Integer id) {
		return repository.findByid(id);
	}
}
