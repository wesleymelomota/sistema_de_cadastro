package com.crud.users.crud_users.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.crud.users.crud_users.config.SecurityConfig;
import com.crud.users.crud_users.model.Role;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FilterToken extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = request.getHeader(JwtCreator.AUTHORIZATION);
		try {
			if(token != null && !token.isEmpty()) {
				JwtObject jwt = JwtCreator.create(token, SecurityConfig.PREFIX, SecurityConfig.getKey());
				List<SimpleGrantedAuthority> authorities = authorities(jwt.getRoles());
				UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(
						jwt.getSubject(),
						null,
						authorities
						);
				SecurityContextHolder.getContext().setAuthentication(userToken);
			}else {
				SecurityContextHolder.clearContext();
			}
			filterChain.doFilter(request, response);
		}catch ( ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			e.printStackTrace();
			response.setStatus(HttpStatus.FORBIDDEN.value());
		}
	}
	private List<SimpleGrantedAuthority> authorities(List<String> roles){
		//return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		return roles.stream().map(r -> new SimpleGrantedAuthority( r)).collect(Collectors.toList());
	}

}
