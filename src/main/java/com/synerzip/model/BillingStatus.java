package com.synerzip.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billing_status")
public class BillingStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;   
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
	private Employee employee;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")	
	private Project project;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")	
	private Role role;
 	
	@Column(name = "billable_status")
	private String billableStatus;
	
	@Column(name = "billing")
	private String billing;
	
	@Column(name = "involvement")
	private float involvement;

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getBillableStatus() {
		return billableStatus;
	}

	public void setBillableStatus(String billableStatus) {
		this.billableStatus = billableStatus;
	}

	public long getId() {
		return id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getBillable_status() {
		return billableStatus;
	}

	public void setBillable_status(String billable_status) {
		this.billableStatus = billable_status;
	}

	public String getBilling() {
		return billing;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}

	public float getInvolvement() {
		return involvement;
	}

	public void setInvolvement(float involvement) {
		this.involvement = involvement;
	}	

	@Override
	public String toString() {
		return "BillingStatus [id=" + id + ", employee=" + employee + ", project=" + project + ", billable_status="
				+ billableStatus + ", billing=" + billing + ", involvement=" + involvement + "]";
	}

	public BillingStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
