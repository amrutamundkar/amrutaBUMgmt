package com.synerzip.auth.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class JwtUser implements UserDetails {

	private static final long serialVersionUID = -8151153112122447310L;

	private Long userId;

	@JsonIgnore
	private String password;

	private String username;

	private boolean enabled;

	@JsonIgnore
	private Set<GrantedAuthority> authorities;

	public JwtUser() {
	}

	public JwtUser(Long userId, String username, String password, boolean enabled, Set<GrantedAuthority> authorities) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	public Long getuserId() {
		return userId;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		if (authorities == null) {
			authorities = new HashSet<>();
		}
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
