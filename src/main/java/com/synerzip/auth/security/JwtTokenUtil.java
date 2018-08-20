package com.synerzip.auth.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	private ObjectMapper objectMapper = new ObjectMapper();

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_ROLES = "roles";
	static final String CLAIM_KEY_CREATED = "created";
	static final String CLAIM_USER_DETAILS = "userDetails";

	public UserDetails getUserDetails(String token) {
		UserDetails userDetails = null;
		try {
			final Claims claims = getClaimsFromToken(token);
			Object obj = claims.get(CLAIM_USER_DETAILS);
			if (obj instanceof String) {
				userDetails = objectMapper.readValue(((String) obj), JwtUser.class);
			}
		} catch (Exception e) {

		}
		return userDetails;
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}
	
	public String generateToken(UserDetails userDetails) throws AuthenticationException {
		Map<String, Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		claims.put(CLAIM_KEY_ROLES, userDetails.getAuthorities());
		claims.put(CLAIM_KEY_CREATED, new Date());
		try {
			claims.put(CLAIM_USER_DETAILS, objectMapper.writeValueAsString(userDetails));
		} catch (JsonProcessingException e) {
			throw new InsufficientAuthenticationException("Unable to write user details in token");
		}
		return generateToken(claims);
	}
	
	String generateToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + expiration * 1000);
	}
	
	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}
	
	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	
	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}
	
	public String refreshToken(String token) {
		String refreshedToken;
		try {
			final Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = generateToken(claims);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}

}
