package com.synerzip.VOs;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.synerzip.model.Employee;
import com.synerzip.model.Project;
import com.synerzip.model.Role;
import com.synerzip.model.Skill;
import com.synerzip.model.Status;

@JsonInclude(Include.NON_NULL)
public class EmployeeVO {

	private long empId;

	private String empFirstName;

	private String empMiddleName;

	private String empLastName;

	private Boolean isActive;

	private String email;

	private int contact;

	private Date dob;

	private String experience;
	
	private Employee empManager;
	
	private Employee employee;
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	private List<Role> roles;

	private List<Skill> skills;
	
	private List<Project> projects;
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Status getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(Status empStatus) {
		this.empStatus = empStatus;
	}



	private Status empStatus;
	
	public List<Role> getRoles() {
		return roles;
	}

	

	private String manager;
	private String Projct;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmpManager() {
		return empManager;
	}

	public void setEmpManager(Employee empManager) {
		this.empManager = empManager;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	
	private String fullname;
	
	

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getProjct() {
		return Projct;
	}

	public void setProjct(String projct) {
		Projct = projct;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpMiddleName() {
		return empMiddleName;
	}

	public void setEmpMiddleName(String empMiddleName) {
		this.empMiddleName = empMiddleName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}


	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public EmployeeVO() {
		
	}
	
	public EmployeeVO(Long empId, String fName,String lName ,String status, String projct,String manager) {
		super();
		this.empId=empId;
		this.empLastName = lName;
		this.empFirstName=fName;
		this.status = status;
		this.Projct = projct;
		this.manager = manager;
		
		
		
	}
	
	
	

	public EmployeeVO(long empId, String empFirstName, String empMiddleName, String empLastName, Boolean isActive,
			String email, int contact, Date dob, String experience, Employee empManager, List<Role> roles,
			List<Skill> skills, List<Project> projects, String status) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empMiddleName = empMiddleName;
		this.empLastName = empLastName;
		this.isActive = isActive;
		this.email = email;
		this.contact = contact;
		this.dob = dob;
		this.experience = experience;
		this.empManager = empManager;
		this.roles = roles;
		this.skills = skills;
		this.projects = projects;
		this.status = status;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public EmployeeVO(long empId, String empFirstName, String empMiddleName, String empLastName) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empMiddleName = empMiddleName;
		this.empLastName = empLastName;
	}

}
