package com.synerzip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.VOs.SkillVO;
import com.synerzip.service.SkillService;

@RestController
public class SkillsController {
	@Autowired
	SkillService skillService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value="/skills")
	public ResponseEntity<List<SkillVO>> getSkills() {
		List<SkillVO> skillList = skillService.getSkills();
		return new ResponseEntity<List<SkillVO>>(skillList, HttpStatus.OK);
	}

}
