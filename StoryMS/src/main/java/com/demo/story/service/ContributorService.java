package com.demo.story.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.story.dto.ContributorDTO;
import com.demo.story.dto.LoginDTO;
import com.demo.story.entity.Contributor;
import com.demo.story.repository.ContributorRepository;

@Service
public class ContributorService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ContributorRepository custRepo;
	
	public void createCustomer(ContributorDTO custDTO) {
		logger.info("Creation request for customer {}", custDTO);
		Contributor cust = custDTO.createEntity();
		custRepo.save(cust);
	}

	// Login
	
	public boolean login(LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
		Optional<Contributor> optCust = custRepo.findById(loginDTO.getPhoneNo());
		if (optCust.isPresent()) {
			Contributor cust = optCust.get();
			if (cust.getPassword().equals(loginDTO.getPassword())) {
				return true;
			}
		}

		return false;
	}
}
