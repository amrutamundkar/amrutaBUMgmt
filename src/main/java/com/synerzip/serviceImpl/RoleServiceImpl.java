package com.synerzip.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.VOs.RoleVO;

import com.synerzip.model.Role;

import com.synerzip.repository.RoleRepository;
import com.synerzip.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<RoleVO> getRoles() {
		List<RoleVO> roleVOList = new ArrayList<RoleVO>();
		List<Role> roleList = roleRepository.findAll();		
		for (Role role : roleList) {
			RoleVO vo = new RoleVO();
			BeanUtils.copyProperties(role, vo);
			roleVOList.add(vo);
		}
		return roleVOList; 
	}

}
