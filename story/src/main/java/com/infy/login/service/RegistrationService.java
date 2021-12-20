package com.infy.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.login.DTO.LoginDTO;
import com.infy.login.model.User;
import com.infy.login.repository.registrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private registrationRepository repo;
	
     public User saveUser(User user)  {
	
    	return repo.save(user);
	
}
     public User fetchUserByEmailId(String email)
     {
    	 return repo.findByEmailId(email);
     }
     public User fetchUserByEmailIdAndPassword(String email, String password) {
     return repo.findByEmailIdAndPassword(email,password);
}
	
}