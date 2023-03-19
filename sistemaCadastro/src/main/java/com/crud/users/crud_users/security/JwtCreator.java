package com.crud.users.crud_users.security;

import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtCreator {

	public static final String AUTHORIZATION = "Authorization";
	public static final String ROLES_AUTHORITIES = "authorities";
	/*identificar pq esta gerando sem o header*/
	public static String create(String prefix, Key key, JwtObject jwt) {
		String token = Jwts.builder()
				.setSubject(jwt.getSubject())
				.setIssuedAt(jwt.getIssuetAT())
				.setExpiration(jwt.getExpiration())
				.claim(ROLES_AUTHORITIES, jwt.getRoles())
				.signWith(key)
				.compact();
		return prefix +  " " + token;
	}
	
	public static JwtObject create(String token, String prefix,  Key key ) {
		token = token.replace(prefix, "");
		Claims jwt = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
		JwtObject jwtObject = new JwtObject();
		jwtObject.setExpiration(jwt.getExpiration());
		jwtObject.setIssuetAT(jwt.getIssuedAt());
		jwtObject.setSubject(jwt.getSubject());
		jwtObject.setRoles((List) jwt.get(ROLES_AUTHORITIES));
		return jwtObject;
	}
	private static List<String> checkRoles(List<String> roles) {
		return roles.stream().map(s -> "ROLE_".concat(s.replaceAll("ROLE_", ""))).collect(Collectors.toList());
	}
}
