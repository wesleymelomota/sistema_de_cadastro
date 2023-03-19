package com.crud.users.crud_users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.users.crud_users.dto.UserDto;
import com.crud.users.crud_users.model.Role;
import com.crud.users.crud_users.model.UserModel;
import com.crud.users.crud_users.repository.RoleRepository;
import com.crud.users.crud_users.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	@Autowired
	private RoleRepository roleRepo;
	/**/
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	public UserDto salvar(UserModel user) {
		Role checkRole = roleRepo.findBynameRole("ADMIN");
		if(checkRole == null) {
			Role role = new Role();
			role.setNameRole("ADMIN");
			roleRepo.save(role);
			
			List<Role> roles = new ArrayList<>();
			roles.add(role);
			user.setRole(roles);
			String pass = user.getPassword();
			user.setPassword(encoder.encode(pass));
			UserDto userDto = new UserDto();
			repository.save(user);
			return userDto.convert(user);
		}else {
			Role roleUser = roleRepo.findBynameRole("USER");
			List<Role> roles = new ArrayList<>();
			if(roleUser == null) {
				Role role = new Role();
				role.setNameRole("USER");
				roleRepo.save(role);
				roles.add(role);
			}else {
				roles.add(roleUser);
			}
			
			user.setRole(roles);
			String pass = user.getPassword();
			user.setPassword(encoder.encode(pass));
			UserDto userDto = new UserDto();
			repository.save(user);
			return userDto.convert(user);
		}
		/*original
		 * List<Role> role = roleRepo.findAllById(user.getRoleIds());
		user.setRole(role);
		
		String pass = user.getPassword();
		user.setPassword(encoder.encode(pass));
		UserDto userDto = new UserDto();
		repository.save(user);
		return userDto.convert(user);*/
	}
	public List<UserModel> obterTodos(){
		return repository.findAll();
	}
}
