package com.synerzip.service;

import java.util.List;

import com.synerzip.model.BillingStatus;

public interface BillingStatusService {

	public Long getStatusCount(String string);

	public List<BillingStatus> getEmpForProject(long id);

}
