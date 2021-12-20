package com.demo.story.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.demo.story.dto.AdminDTO;
import com.demo.story.dto.ContributorDTO;
import com.demo.story.dto.LoginDTO;
import com.demo.story.service.AdminService;
import com.demo.story.service.ContributorService;

@RestController
@CrossOrigin
public class AdminController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AdminService adminService;
	
	@GetMapping(value = "/admin",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getAdmin(@RequestBody AdminDTO adminDTO) throws RestClientException, IOException
	
	
	{
	String baseUrl = "http://localhost:8080/login";


			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> response=null;
			try  {
			response=restTemplate.exchange(baseUrl,
					HttpMethod.GET, getHeaders(),String.class);

			}

			catch (Exception ex)
			{ 
			System.out.println(ex);
			}
			
			System.out.println(response.getBody());
			//return null();
			return response.getBody().toString();
	
	}
	// Login
	private HttpEntity getHeaders()  throws IOException{
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		// TODO Auto-generated method stub
		return new HttpEntity<>(headers);
	}
	
	
	
	
	// Create a new customer
		//@PostMapping(value = "/admin",  consumes = MediaType.APPLICATION_JSON_VALUE)
		//public void createCustomer(@RequestBody AdminDTO adminDTO) {
			//logger.info("Creation request for admin {}", adminDTO);
			//adminService.createAdmin(adminDTO);
		//}


	@PostMapping(value = "/admin/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for admin {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
		return adminService.login(loginDTO);
	}
	

}
