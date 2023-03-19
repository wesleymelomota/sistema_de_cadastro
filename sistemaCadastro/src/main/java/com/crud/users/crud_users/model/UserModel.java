package com.crud.users.crud_users.model;
import java.util.ArrayList;
import java.util.Collection;
//import com.crud.users.crud_users.enums.Role;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class UserModel implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(unique = true)
	private String username;
	private String email;
	private String password;
	//@Enumerated(EnumType.STRING)
	@ManyToMany
	private List<Role> role;
	
	public UserModel() {}
	
	public Integer getId() {
		return id;
	}

	public List<String> getRoleStr() {
		List<String> roles = new ArrayList<>();
		role.stream().forEach(o -> roles.add(o.getNameRole()));
		return roles;
	}
	public List<Integer> getRoleIds(){
		List<Integer> ids = new ArrayList<>();
		role.stream().forEach(o -> ids.add(o.getId()));
		return ids;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public List<Role> getRole() {
		return role;
	}



	public void setRole(List<Role> role) {
		this.role = role;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(((Role) role).getNameRole()));
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public String getUsername() {
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
