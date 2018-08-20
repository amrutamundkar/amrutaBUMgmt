package com.synerzip.service;

import java.util.List;

import com.synerzip.VOs.EmployeeRoleMappingVO;
import com.synerzip.model.EmployeeRoleMapping;


public interface EmployeeRoleMappingService {

	List<EmployeeRoleMapping> getRolesforEmp(long id);

}
