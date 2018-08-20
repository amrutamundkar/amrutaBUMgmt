package com.synerzip.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.VOs.SkillVO;
import com.synerzip.VOs.StatusVO;
import com.synerzip.model.Skill;
import com.synerzip.model.Status;
import com.synerzip.repository.StatusRepository;
import com.synerzip.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	StatusRepository statusRepository;
	

	@Override
	public List<StatusVO> statusListgetStatus() {
		List<StatusVO> statusVOList = new ArrayList<StatusVO>();
		List<Status> statusList = statusRepository.findAll();
		//BeanUtils.copyProperties(studentModelList, studentVOList);
		for (Status status : statusList) {
			StatusVO vo = new StatusVO();
			BeanUtils.copyProperties(status, vo);
			statusVOList.add(vo);
		}
		return statusVOList; 
	}

}
