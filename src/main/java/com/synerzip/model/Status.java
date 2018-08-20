package com.synerzip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "status")
public class Status {
	@Id
	@Column(name = "status_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long statusId;
	
	@Column(nullable = false)
	private String statusType;

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	

}
