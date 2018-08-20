package com.synerzip.auth.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.auth.security.VOs.ApplicationUserVO;

import com.synerzip.auth.userservice.ApplicationUserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	ApplicationUserService applicationUserService;
	
	
    @PostMapping(value ="/signup")
    public ResponseEntity<ApplicationUserVO> signUp(@RequestBody ApplicationUserVO applicationUserVO) {  	
    	
    		try {
    			ApplicationUserVO result = applicationUserService.saveApplicationUser(applicationUserVO);
    			return new ResponseEntity<ApplicationUserVO>(result, HttpStatus.OK);

    		} catch (Exception e) {
    			return new ResponseEntity<ApplicationUserVO>(new ApplicationUserVO(), HttpStatus.EXPECTATION_FAILED);
    		}
    	}
    	
    	
    
}