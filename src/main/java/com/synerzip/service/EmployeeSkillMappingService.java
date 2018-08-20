package com.synerzip.service;

import java.util.List;

import com.synerzip.VOs.EmployeeSkillMappingVO;
import com.synerzip.model.EmployeeSkillMapping;

public interface EmployeeSkillMappingService {

	List<EmployeeSkillMapping> getSkillsforEmp(long id);

}
