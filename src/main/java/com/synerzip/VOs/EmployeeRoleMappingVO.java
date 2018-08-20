package com.synerzip.VOs;

import com.synerzip.model.Employee;
import com.synerzip.model.Role;

public class EmployeeRoleMappingVO {
	
	private Employee employee;
		
	private Role role;
	
	private Employee managerId;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getManagerId() {
		return managerId;
	}

	public void setManagerId(Employee managerId) {
		this.managerId = managerId;
	}

	public EmployeeRoleMappingVO( Employee managerId,Role role) {
		super();
		
		this.role = role;
		this.managerId = managerId;
	}
	

}
