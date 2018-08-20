package com.synerzip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synerzip.model.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {



//	@Query("SELECT COUNT (employee) FROM BillingStatus WHERE project_id like ?1 ")
//	Long getTeamProjectCount(Long projectId);
//
//	@Query("select COUNT(employee) as billableCount from Billing_status where project_id like ?1 and billableStatus = billable ")
//	Long getBillableOnProjectCount(Long projectId);
//	
//	@Query("select COUNT(employee) as devCount from Billing_status where project_id like ?1 and role = 1 ")
//	Long getDevOnProjectCount(Long projectId);
//	
//	@Query("select COUNT(employee) as testingCount from Billing_status where project_id like ?1 and role = 2")
//	Long getTestersOnProjectCount(Long projectId);

}
