package com.synerzip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.VOs.RoleVO;
import com.synerzip.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value="/roles")
	public ResponseEntity<List<RoleVO>> getRoles() {
		List<RoleVO> roleList = roleService.getRoles();
		return new ResponseEntity<List<RoleVO>>(roleList, HttpStatus.OK);
	}

}
