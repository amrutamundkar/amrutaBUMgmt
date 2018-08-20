package com.synerzip.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.VOs.SkillVO;
import com.synerzip.model.Skill;
import com.synerzip.repository.SkillRepository;
import com.synerzip.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillRepository skillRepository;

	@Override
	public List<SkillVO> getSkills() {
		List<SkillVO> skillVOList = new ArrayList<SkillVO>();
		List<Skill> skillList = skillRepository.findAll();
		//BeanUtils.copyProperties(studentModelList, studentVOList);
		for (Skill skill : skillList) {
			SkillVO vo = new SkillVO();
			BeanUtils.copyProperties(skill, vo);
			skillVOList.add(vo);
		}
		return skillVOList; 
	}

}
