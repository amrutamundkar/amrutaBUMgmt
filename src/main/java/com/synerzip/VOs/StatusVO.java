package com.synerzip.VOs;

import javax.persistence.Column;

public class StatusVO {
	
	private long statusId;
	
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
