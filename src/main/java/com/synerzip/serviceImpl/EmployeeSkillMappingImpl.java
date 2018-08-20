package com.synerzip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.VOs.EmployeeSkillMappingVO;

import com.synerzip.model.EmployeeSkillMapping;
import com.synerzip.repository.EmployeeRepository;
import com.synerzip.repository.EmployeeSkillMappingRepository;
import com.synerzip.service.EmployeeSkillMappingService;

@Service
public class EmployeeSkillMappingImpl implements EmployeeSkillMappingService {

	@Autowired
	EmployeeSkillMappingRepository employeeSkillMappingRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeSkillMapping> getSkillsforEmp(long id) {
		
		List<EmployeeSkillMapping> skillsList = 
				employeeSkillMappingRepository.findByEmployee(employeeRepository.findOne(id));
				return skillsList;	
		
		 
	}

}
