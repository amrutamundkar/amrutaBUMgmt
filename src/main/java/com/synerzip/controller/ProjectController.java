package com.synerzip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.VOs.EmployeeVO;
import com.synerzip.VOs.ProjectVO;
import com.synerzip.VOs.SkillVO;
import com.synerzip.model.BillingStatus;
import com.synerzip.model.EmployeeRoleMapping;
import com.synerzip.model.EmployeeSkillMapping;
import com.synerzip.service.BillingStatusService;
import com.synerzip.service.EmployeeRoleMappingService;
import com.synerzip.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	BillingStatusService billingStatusService;
	
	@Autowired
	EmployeeRoleMappingService employeeRoleMappingService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value="/projects")
	public ResponseEntity<List<ProjectVO>> getSkills() {
		
		List<ProjectVO> projectList = projectService.getProjects();		
		return new ResponseEntity<List<ProjectVO>>(projectList, HttpStatus.OK);
	}
	
//	@CrossOrigin(origins = "http://localhost:3000")
//	@GetMapping(value = "/projectinfo/{id}")
//	public ResponseEntity<List<BillingStatus>> getEmployeeCount(@PathVariable("id") long id) {
//		
//		List<BillingStatus> billingStatusList = billingStatusService.getEmpForProject(id);
//		
//		
//		
//		return new ResponseEntity<List<BillingStatus>>(billingStatusList, HttpStatus.OK);
//	}


}
