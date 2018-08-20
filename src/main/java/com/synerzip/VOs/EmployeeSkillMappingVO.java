package com.synerzip.VOs;


import com.synerzip.model.Employee;
import com.synerzip.model.Skill;

public class EmployeeSkillMappingVO {

	private Employee employee;
		
	private Skill skill;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public EmployeeSkillMappingVO(Skill skill) {
		super();
		
		this.skill = skill;
	}
	
	
}
