package com.infy.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.login.DTO.LoginDTO;
import com.infy.login.model.User;
import com.infy.login.service.RegistrationService;

@RestController
public class LoginController {
	
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RegistrationService service;
	
	
	@GetMapping("/registeruser")
    public User registerUser(@RequestBody User user)  throws Exception {
		String tempEmailId = user.getEmailId();
		
		if(tempEmailId  != null & !"".equals(tempEmailId))  {
			User userobj = service.fetchUserByEmailId(tempEmailId);
			if(userobj  != null) {
				throw new Exception("user with "+tempEmailId+" is already exists");
		}
		
	}
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;		
    
	}
	
	
	/*@PostMapping(value = "/admin",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody RegistrationDTO registrationDTO) {
		logger.info("Creation request for admin {}", registrationDTO);
		RegistrationService.createAdmin(registrationDTO);
	}
*/
	
	
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj = null;
		if (tempEmailId !=null & tempPass !=null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj == null) {
			throw new Exception("WRONG CREDENTIALS");
		}
		return userObj;
	}
	
}