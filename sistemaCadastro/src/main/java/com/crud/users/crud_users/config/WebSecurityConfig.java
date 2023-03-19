package com.crud.users.crud_users.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.crud.users.crud_users.security.FilterToken;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	/**/ 
	@Bean 
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.cors().and().csrf().disable()
			.addFilterBefore(new FilterToken(), UsernamePasswordAuthenticationFilter.class)
			.authorizeHttpRequests()
			.requestMatchers(HttpMethod.POST, "/role/create").permitAll()
			.requestMatchers(HttpMethod.POST, "/usuario").permitAll()
			.requestMatchers(HttpMethod.GET, "/usuario").permitAll()
			.requestMatchers(HttpMethod.POST, "/login").permitAll()
			.requestMatchers("/cliente/obter-todos").hasAnyAuthority("USER", "ADMIN")
			.requestMatchers(HttpMethod.GET, "/user-pag").hasRole("USER")
			.requestMatchers("/cliente/hello").hasAnyAuthority("USER", "ADMIN")
			.requestMatchers(HttpMethod.GET, "/cliente/obter/**").hasAnyAuthority( "ADMIN")
			.requestMatchers(HttpMethod.POST,"/cliente/save").hasAnyAuthority("ADMIN")
			.requestMatchers(HttpMethod.PUT,"/cliente/update").hasAnyAuthority("ADMIN")
			.requestMatchers(HttpMethod.DELETE,"/cliente/delete").hasAnyAuthority("ADMIN")
			.anyRequest().authenticated().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		return http.build();
		
	}
	@Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
    }
}
