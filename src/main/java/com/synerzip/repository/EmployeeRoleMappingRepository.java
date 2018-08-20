package com.synerzip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synerzip.VOs.EmployeeRoleMappingVO;
import com.synerzip.model.Employee;
import com.synerzip.model.EmployeeRoleMapping;


public interface EmployeeRoleMappingRepository  extends JpaRepository<EmployeeRoleMapping,Long> {
//
//	@Query("SELECT new com.synerzip.VOs.EmployeeRoleMapping ( er.managerId,er.role )from Employee e "
//			+ "left join e.employeeRoleMapping er where e.empId like ?1")
//	List<EmployeeRoleMapping> getroleAndManager(long id);
	
	
	public List<EmployeeRoleMapping> findByEmployee(Employee employee);

}
