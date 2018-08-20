package com.synerzip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synerzip.model.Role;

public interface RoleRepository  extends JpaRepository<Role, Long> {

}
