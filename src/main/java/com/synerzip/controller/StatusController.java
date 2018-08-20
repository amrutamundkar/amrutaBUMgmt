package com.synerzip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.VOs.SkillVO;
import com.synerzip.VOs.StatusVO;
import com.synerzip.service.SkillService;
import com.synerzip.service.StatusService;

@RestController
public class StatusController {
	@Autowired
	StatusService statusService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value="/status")
	public ResponseEntity<List<StatusVO>> getStatus() {
		List<StatusVO> statusList = statusService.statusListgetStatus();
		return new ResponseEntity<List<StatusVO>>(statusList, HttpStatus.OK);
	}
}
