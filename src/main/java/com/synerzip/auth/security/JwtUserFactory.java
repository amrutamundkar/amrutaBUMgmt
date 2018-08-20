package com.synerzip.auth.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.synerzip.auth.model.ApplicationUser;
import com.synerzip.auth.model.LinkUserRole;


public final class JwtUserFactory {
	private JwtUserFactory() {
	}

	public static JwtUser create(ApplicationUser user) {
		Set<GrantedAuthority> setOfRoles = new HashSet<>();
		Set<String> roles = new HashSet<>();
		populateSets(user.getLinkUserRoles(), setOfRoles, roles);
		return new JwtUser(user.getUserId(), user.getUsername(), user.getPassword(), user.getEnabled(), setOfRoles);
	}

	private static void populateSets(List<LinkUserRole> linkUserRoles, Set<GrantedAuthority> setOfRoles, Set<String> roles) {
		if (linkUserRoles != null) {
			for (LinkUserRole linkUserRole : linkUserRoles) {
				if (linkUserRole != null && linkUserRole.getRole() != null) {
					setOfRoles.add(new SimpleGrantedAuthority(linkUserRole.getRole().getRoleName()));
					roles.add(linkUserRole.getRole().getRoleName());
				}
			}
		}
	}

}
