package com.synerzip.service;

import java.util.List;

import com.synerzip.VOs.ProjectVO;

public interface ProjectService {

	Long teamOnProjectCount(Long projectId);

	List<ProjectVO> getProjects();

	Long getProjectCount();

	Long getbillableOnProjectCount(Long projectId);

}
