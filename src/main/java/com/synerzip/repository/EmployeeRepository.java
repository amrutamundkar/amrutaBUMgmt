package com.synerzip.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synerzip.VOs.EmployeeVO;
import com.synerzip.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	 /*@Query("select org from OrganizationModel org where org.organizationType = :organizationType")
	  Page<OrganizationModel> getOrganizationByOrganizationType(
	      @Param("organizationType") String organizationType, Pageable pageRequest);
	*/

	@Query("SELECT new com.synerzip.VOs.EmployeeVO(e.empId , e.empFirstName, e.empMiddleName, e.empLastName) FROM Employee e where e.empFirstName like ?1)")
	Page<EmployeeVO> getEmployeesPagenation(String string, Pageable pageRequest);
	
	@Query("SELECT new com.synerzip.VOs.EmployeeVO(e.empId,e.empFirstName,e.empLastName,bs.billableStatus,p.projectName,er.managerId.empFirstName) FROM Employee e "
			   +"left join e.billingStatus bs "
			   + "left join bs.project p "
			   + "left join e.employeeRoleMapping er where e.empFirstName like ?1")	
	Page<EmployeeVO> getEmployees(String string, Pageable pageRequest);

}
