package com.synerzip.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.service.BillingStatusService;
import com.synerzip.service.EmployeeService;

@RestController
@RequestMapping(value = "api/dashboard")
public class DashboardController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	BillingStatusService billingStatusService;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/data")
	public ResponseEntity<Map<String, Long>> getEmployeeCount() {

		Long countBench = billingStatusService.getStatusCount("bench");
		Long countBillable = billingStatusService.getStatusCount("billable");
		Long countPip = billingStatusService.getStatusCount("PIP");
		Long countOtherBU = billingStatusService.getStatusCount("Hired from other BU");
		Long headcount = employeeService.getHeadCount();

		Map<String, Long> map = new HashMap<>();
		map.put("bench", countBench);
		map.put("billable", countBillable);
		map.put("headcount", headcount);
		map.put("PIP", countPip);
		map.put("OtherBU", countOtherBU);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
