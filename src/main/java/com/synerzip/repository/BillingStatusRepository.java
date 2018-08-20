package com.synerzip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synerzip.model.BillingStatus;

public interface BillingStatusRepository extends JpaRepository<BillingStatus, Long>{

	List<BillingStatus> findByProject(BillingStatus findOne);

	//long countByBillableStatus(String billableStatus);
}
