package com.synerzip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.VOs.EmployeeRoleMappingVO;
import com.synerzip.model.EmployeeRoleMapping;
import com.synerzip.repository.EmployeeRepository;
import com.synerzip.repository.EmployeeRoleMappingRepository;
import com.synerzip.service.EmployeeRoleMappingService;


@Service
public class EmployeeRoleMappingServiceImpl implements EmployeeRoleMappingService {

	@Autowired
	EmployeeRoleMappingRepository employeeRoleMappingRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeRoleMapping> getRolesforEmp(long id) {
		List<EmployeeRoleMapping> rolesList = 
				employeeRoleMappingRepository.findByEmployee(employeeRepository.findOne(id));
		return rolesList;
	}

}
