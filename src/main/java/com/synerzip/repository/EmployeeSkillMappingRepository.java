package com.synerzip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synerzip.VOs.EmployeeSkillMappingVO;
import com.synerzip.model.Employee;
import com.synerzip.model.EmployeeSkillMapping;

public interface EmployeeSkillMappingRepository  extends JpaRepository<EmployeeSkillMapping,Long> {

	@Query("SELECT new com.synerzip.VOs.EmployeeSkillMappingVO ( s.skill)from EmployeeSkillMapping s where s.employee like ?1")
	List<EmployeeSkillMappingVO> getSkills(long id);

	List<EmployeeSkillMapping> findByEmployee(Employee employee);

}
