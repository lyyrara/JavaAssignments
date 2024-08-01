package com.example.catalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.catalogservice.DAO.catalogserviceDAO;
import com.example.catalogservice.model.Course;



@RestController
public class catalogserviceController {
	
	@Autowired
	catalogserviceDAO catalogserviceDAO;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getCatalog/{userId}")
	public List<Course> getCatalog( @PathVariable String userId ) {
		
		
		List<Course> enrolled_courses = restTemplate.getForObject("http://enrolledservice/enrolled/"+userId, List.class);
		
		
		return enrolled_courses;
	}


	// @GetMapping("/allUsers")
	// public List<User> getAllUsers() {
	// 	List<User> users = catalogserviceDAO.allUsers();
	// 	List<Contact> contacts = restTemplate.getForObject("http://localhost:8081/allContacts", List.class);
	// 	for(User user: users){
	// 		String userId = user.getUserId();
	// 		Contact contact = contacts.get()
	// 	}

	// 	return users;
	// }
	

	

}