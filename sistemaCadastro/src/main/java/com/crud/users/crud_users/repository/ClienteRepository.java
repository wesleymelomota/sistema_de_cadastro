package com.crud.users.crud_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.users.crud_users.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	Cliente findByid(Integer id);
	Cliente findBynome(String nome);
}
