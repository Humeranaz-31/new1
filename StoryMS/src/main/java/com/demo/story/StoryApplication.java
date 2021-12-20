package com.demo.story;

import java.io.IOException;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.demo.story.controller.AdminController;

@SpringBootApplication

public class StoryApplication {
	
	

	public static void main(String[] args) throws RestClientException, IOException{
		ApplicationContext ctx= (ApplicationContext) SpringApplication.run(StoryApplication.class, args);
		
		
		//AdminController adminController = ((BeanFactory) ctx).getBean(AdminController.class);
		
		//adminController.getAdmin(null);
	}
	
	/*@Bean
	public AdminController adminController()
	{
		return new AdminController();
	}
}
*/
}
