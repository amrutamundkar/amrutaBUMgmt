package com.synerzip.auth.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.synerzip.auth.model.ApplicationUser;
import com.synerzip.auth.security.JwtUserFactory;
import com.synerzip.auth.userRepository.ApplicationUserRepository;

import static java.util.Collections.emptyList;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private ApplicationUserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser user = userRepository.findByUsernameIgnoreCase(username);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {

			return JwtUserFactory.create(user);
		}
	}
}
