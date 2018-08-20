package com.synerzip.serviceImpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.synerzip.DTOs.PaginationResponseDto;
import com.synerzip.VOs.EmployeeVO;

import com.synerzip.exceptions.EmployeeProfileCreationException;
import com.synerzip.model.BillingStatus;
import com.synerzip.model.Employee;
import com.synerzip.model.EmployeeRoleMapping;
import com.synerzip.model.EmployeeSkillMapping;
import com.synerzip.model.Project;
import com.synerzip.model.Role;
import com.synerzip.model.Skill;
import com.synerzip.repository.BillingStatusRepository;
import com.synerzip.repository.EmployeeRepository;
import com.synerzip.repository.EmployeeRoleMappingRepository;
import com.synerzip.repository.EmployeeSkillMappingRepository;
import com.synerzip.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final static int PAGESIZE = 3;

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	BillingStatusRepository billingStatusRepository;
	
	@Autowired
	EmployeeRoleMappingRepository employeeRoleMappingRepository;

	@Autowired
	EmployeeSkillMappingRepository employeeSkillMappingRepository;
	
	@Override
	public Long getHeadCount() {
		return employeeRepository.count();
	}

	@Override
	@Transactional
	public EmployeeVO saveEmployee(EmployeeVO employeeVO) {
		
		EmployeeVO employeeModelVO = new EmployeeVO();
		
		employeeModelVO.setEmpFirstName(employeeVO.getEmpFirstName());
		employeeModelVO.setEmpMiddleName(employeeVO.getEmpMiddleName());
		employeeModelVO.setEmpLastName(employeeVO.getEmpLastName());
		employeeModelVO.setContact(employeeVO.getContact());
		employeeModelVO.setDob(employeeVO.getDob());
		employeeModelVO.setEmail(employeeVO.getEmail());
		employeeModelVO.setExperience(employeeVO.getExperience());	
				
		try {
			Employee emp = new Employee();
			BeanUtils.copyProperties(employeeModelVO, emp);			
			Employee employee= employeeRepository.save(emp);			
					
			
			if(employee!=null) {
				List<Role> rolesList = new ArrayList<>();
				rolesList=employeeVO.getRoles();
			
				rolesList.forEach(role ->{
					EmployeeRoleMapping employeeRoleMapping = new EmployeeRoleMapping();
					System.out.println(role.getRoleName());
					employeeRoleMapping.setEmployee(employee);
					employeeRoleMapping.setManager_id(employeeVO.getEmpManager());
					employeeRoleMapping.setRole(role);
					employeeRoleMappingRepository.save(employeeRoleMapping);

				});
				
				List<Project> projectList = new ArrayList<>();
				projectList=employeeVO.getProjects();
			
				projectList.forEach(project ->{
					BillingStatus billingStatus = new BillingStatus();
					System.out.println(project.getProjectName());
					billingStatus.setEmployee(employee);
					billingStatus.setProject(project);
					billingStatus.setBillableStatus(employeeVO.getStatus());
					billingStatusRepository.save(billingStatus);

				});
				
				List<Skill> skillList =  new ArrayList<>();
				skillList=employeeVO.getSkills();				
				skillList.forEach(skill ->{
					EmployeeSkillMapping employeeSkillMapping = new EmployeeSkillMapping();
					employeeSkillMapping.setEmployee(employee);
					employeeSkillMapping.setSkill(skill);
					employeeSkillMappingRepository.save(employeeSkillMapping);
				});	
				return employeeModelVO;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			System.out.println("Exception occured " + e);
			throw new EmployeeProfileCreationException("Error Occured While creating Employee");
		}

	}

	
	@Override
	public EmployeeVO getEmployee(long id) {		
		Employee employee = employeeRepository.findOne(id);
		EmployeeVO empvo = new EmployeeVO();
		BeanUtils.copyProperties(employee, empvo);
		return empvo;
	}

	@Override
	public void deleteEmployees(long id) {
		employeeRepository.delete(id);
	
	}

	
	@Override
	public PaginationResponseDto<EmployeeVO> getEmployeesPagenation(Integer page, Integer pageSize, String sortOn, String sortOrder, String searchText) {
		PaginationResponseDto<EmployeeVO> result = new PaginationResponseDto<EmployeeVO>();
		Sort sort = new Sort("ASC".equalsIgnoreCase(sortOrder) ? Sort.Direction.ASC : Sort.Direction.DESC, sortOn);
		PageRequest pageRequest = new PageRequest(page, pageSize, sort);
		Page<EmployeeVO> employees = employeeRepository.getEmployees("%" + searchText + "%", pageRequest);
		if (employees != null) {
			result.setCount(employees.getNumberOfElements());
			result.setPage(page);
			result.setTotalItems(employees.getTotalElements());
			result.setTotalPages(employees.getTotalPages());
			List<EmployeeVO> employeesList = employees.getContent();
			result.setItems(employeesList);
		}
		
		return result;
	}

	@Override
	public List<EmployeeVO> getEmpList() {
		List<EmployeeVO> empVOList = new ArrayList<EmployeeVO>();
		List<Employee> empList = employeeRepository.findAll();		
		for (Employee emp : empList) {
			EmployeeVO vo = new EmployeeVO();
			BeanUtils.copyProperties(emp, vo);
			empVOList.add(vo);
		}
		return empVOList; 
	
	}

	@Override
	public PaginationResponseDto<EmployeeVO> getProjectEmployeesPagenation(Integer page, Integer pageSize,
			String sortOn, String sortOrder, String searchText) {
		PaginationResponseDto<EmployeeVO> result = new PaginationResponseDto<EmployeeVO>();
		Sort sort = new Sort("ASC".equalsIgnoreCase(sortOrder) ? Sort.Direction.ASC : Sort.Direction.DESC, sortOn);
		PageRequest pageRequest = new PageRequest(page, pageSize, sort);
		
//		Page<EmployeeVO> employees = employeeRepository.getprojectEmployees("%" + searchText + "%", pageRequest);
//		if (employees != null) {
//			result.setCount(employees.getNumberOfElements());
//			result.setPage(page);
//			result.setTotalItems(employees.getTotalElements());
//			result.setTotalPages(employees.getTotalPages());
//			List<EmployeeVO> employeesList = employees.getContent();
//			result.setItems(employeesList);
//		}
		
		return result;
	}
}
