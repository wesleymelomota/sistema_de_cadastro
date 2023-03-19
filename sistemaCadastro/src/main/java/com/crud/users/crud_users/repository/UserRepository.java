package com.crud.users.crud_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.users.crud_users.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
	
	UserModel findByusername(String username);
}
