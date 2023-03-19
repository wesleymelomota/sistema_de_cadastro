package com.crud.users.crud_users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.users.crud_users.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Role findBynameRole(String name);
	Role findByid(Integer id);
	List<Role> findAllByid(Object object);
	boolean existsBynameRole(String userName);
}
