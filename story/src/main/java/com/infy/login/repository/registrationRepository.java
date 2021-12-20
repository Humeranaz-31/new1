package com.infy.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.login.model.User;


public interface registrationRepository extends JpaRepository<User, Integer>
{
	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId, String password);

}
