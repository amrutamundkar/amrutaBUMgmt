package com.synerzip.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;

	@Column(nullable = false)
	private String empFirstName;

	@Column(nullable = true)
	private String empMiddleName;
	
	@OneToMany(mappedBy = "employee")
	 private List<BillingStatus> billingStatus;
	
	 @OneToMany(mappedBy = "employee")
	 private List<EmployeeRoleMapping> employeeRoleMapping;


	public List<BillingStatus> getBillingStatus() {
		return billingStatus;
	}

	public void setBillingStatus(List<BillingStatus> billingStatus) {
		this.billingStatus = billingStatus;
	}

	public List<EmployeeRoleMapping> getEmployeeRoleMapping() {
		return employeeRoleMapping;
	}

	public void setEmployeeRoleMapping(List<EmployeeRoleMapping> employeeRoleMapping) {
		this.employeeRoleMapping = employeeRoleMapping;
	}

	@Column(nullable = false)
	private String empLastName;

	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime createdDate;

	private String createdBy;

	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime modifiedDate;

	private String email;

	private long contact;

	private Date dob;

	private String experience;

	private String modifiedBy;

	private Boolean isActive = true;

	public long getEmpId() {
		return empId;
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
