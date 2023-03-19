package com.crud.users.crud_users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.users.crud_users.dto.ClienteDto;
import com.crud.users.crud_users.model.Cliente;
import com.crud.users.crud_users.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
@CrossOrigin
public class ControllerCli {
	@Autowired
	private ClienteService service;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		//ClienteDto clienteDto = new ClienteDto();
		service.salvar(cliente);
		return ResponseEntity.ok().body(cliente);
	}
	@GetMapping("/obter-todos")
	public ResponseEntity<List<Cliente> >obterTodos(){
		return ResponseEntity.ok().body(service.obterTodos());
	}
	@GetMapping("/obter/{id}")
	public ResponseEntity<Cliente> obterCliente(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.getCliente(id));
	}
	@GetMapping("/hello")
	public String hello() {
		return "Olá, manager";
	}
	@PutMapping("/update")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente){
		service.salvar(cliente);
		return ResponseEntity.ok().body(cliente);
	}
	@DeleteMapping("/delete/{id}")
	public void excluirCli(@PathVariable Integer id) {
		service.deletar(id);
		
	}
}
