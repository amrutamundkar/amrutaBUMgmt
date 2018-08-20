package com.synerzip.auth.usercontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.auth.model.ApplicationUser;
import com.synerzip.auth.security.JwtTokenUtil;
import com.synerzip.auth.security.JwtUser;
import com.synerzip.auth.security.VOs.JwtAuthenticationRequestVO;
import com.synerzip.auth.security.VOs.JwtAuthenticationResponseVO;

@RestController
public class AuthenticationRestController {

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;
	
	

	@PostMapping(value = "auth")
	@CrossOrigin(exposedHeaders="authorization")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequestVO authenticationRequest) throws AuthenticationException {

		// Perform the security
		final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-security so we can generate token
		final JwtUser userDetails = (JwtUser) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);

		// Return the user details and token
		HttpHeaders headers = new HttpHeaders();
		headers.add(tokenHeader, token);
		return ResponseEntity.ok().headers(headers).body(authentication.getPrincipal());
	}	

   
	@GetMapping(value = "refreshtoken")
	public ResponseEntity<?> demo(HttpServletRequest request) {
		String token = request.getHeader(tokenHeader);
		String refreshedToken = jwtTokenUtil.refreshToken(token);
		return ResponseEntity.ok(new JwtAuthenticationResponseVO(refreshedToken));
	}

}
