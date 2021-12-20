package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.registration.model.User;
import com.infy.registration.repository.registrationRepository;

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