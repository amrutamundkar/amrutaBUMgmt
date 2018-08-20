package com.synerzip.auth.userserviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.synerzip.auth.exceptions.UserProfileCreationException;
import com.synerzip.auth.model.ApplicationUser;
import com.synerzip.auth.security.VOs.ApplicationUserVO;
import com.synerzip.auth.userRepository.ApplicationUserRepository;
import com.synerzip.auth.userservice.ApplicationUserService;


@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {
	
	@Autowired
	ApplicationUserRepository applicationUserRepository;

    
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


	@Override
	@Transactional
	public ApplicationUserVO saveApplicationUser(ApplicationUserVO userVO) {
		try {
			ApplicationUser user = new ApplicationUser();
			BeanUtils.copyProperties(userVO, user);
			
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			
			applicationUserRepository.save(user);
			userVO.setUserId(user.getUserId());
			return userVO;	    	
	        
	        
		} catch (Exception e) {
			System.out.println("Exception occured " + e);
			throw new UserProfileCreationException("Error Occured While creating User");
		}

	}
	
	

}
