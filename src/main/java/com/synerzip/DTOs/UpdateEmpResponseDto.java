package com.synerzip.DTOs;

import java.util.List;

public class UpdateEmpResponseDto<T> {
	private List<T> roles;
	private List<T> skills;
	public List<T> getRoles() {
		return roles;
	}
	public void setRoles(List<T> roles) {
		this.roles = roles;
	}
	public List<T> getSkills() {
		return skills;
	}
	public void setSkills(List<T> skills) {
		this.skills = skills;
	}
	
	

}
