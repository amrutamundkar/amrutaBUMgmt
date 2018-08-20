package com.synerzip.auth.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synerzip.auth.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
	ApplicationUser findByUsernameIgnoreCase(String userName);
}