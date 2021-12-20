package com.demo.story.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.story.entity.Admin;
import com.demo.story.entity.Contributor;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	

}
