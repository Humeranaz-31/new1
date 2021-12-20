package com.demo.story.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.story.dto.AdminDTO;
import com.demo.story.dto.ContributorDTO;
import com.demo.story.dto.LoginDTO;
import com.demo.story.entity.Admin;
import com.demo.story.entity.Contributor;
import com.demo.story.repository.AdminRepository;
import com.demo.story.repository.ContributorRepository;

@Service
public class AdminService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AdminRepository adminRepo;
	
	public void createAdmin(AdminDTO adminDTO) {
		logger.info("Creation request for customer {}", adminDTO);
		Admin admin = adminDTO.createEntity();
		adminRepo.save(admin);
	}

	// Login
	
	public boolean login(LoginDTO loginDTO) {
		logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
		Optional<Admin> optAdmin = adminRepo.findById(loginDTO.getPhoneNo());
		if (optAdmin.isPresent()) {
			Admin admin = optAdmin.get();
			if (admin.getPassword().equals(loginDTO.getPassword())) {
				return true;
			}
		}

		return false;
	}
}
