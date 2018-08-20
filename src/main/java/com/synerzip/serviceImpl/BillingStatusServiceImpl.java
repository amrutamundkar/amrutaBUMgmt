package com.synerzip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.model.BillingStatus;
import com.synerzip.model.EmployeeRoleMapping;
import com.synerzip.repository.BillingStatusRepository;
import com.synerzip.service.BillingStatusService;

@Service
public class BillingStatusServiceImpl implements BillingStatusService{
	
	@Autowired
	BillingStatusRepository billingStatusRepository;

	@Override
	public Long getStatusCount(String statusName) {
		//return billingStatusRepository.countByBillableStatus(statusName);
		return null;
	}

	@Override
	public List<BillingStatus> getEmpForProject(long id) {
		List<BillingStatus> billingStatusList = 
				billingStatusRepository.findByProject(billingStatusRepository.findOne(id));
		return billingStatusList;
	}

	

}
