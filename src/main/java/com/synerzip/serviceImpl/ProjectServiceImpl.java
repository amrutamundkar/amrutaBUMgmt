package com.synerzip.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.VOs.ProjectVO;
import com.synerzip.VOs.RoleVO;
import com.synerzip.model.Project;
import com.synerzip.model.Role;
import com.synerzip.repository.ProjectRepository;
import com.synerzip.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;	

	
	@Override
	public Long teamOnProjectCount(Long projectId) {
		return null;
	}

	@Override
	public List<ProjectVO> getProjects() {
		List<ProjectVO> projectVOList = new ArrayList<ProjectVO>();
		List<Project> projectList = projectRepository.findAll();		
		for (Project project : projectList) {
			ProjectVO vo = new ProjectVO();
			BeanUtils.copyProperties(project, vo);
			projectVOList.add(vo);
		}
		return projectVOList;
	}

	@Override
	public Long getProjectCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getbillableOnProjectCount(Long projectId) {
		// TODO Auto-generated method stub
		return null;
	}

}
