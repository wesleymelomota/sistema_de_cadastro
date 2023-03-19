package com.crud.users.crud_users.config;

import java.security.Key;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {
	
	public static String PREFIX;
	public static Long EXPIRATION;
	private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public void setPrefix(String prefix) {
		PREFIX = prefix;
	}
	public void setExpiration(Long exp) {
		EXPIRATION = exp;
	}
	public static Key getKey() {
		return key;
	}
}
