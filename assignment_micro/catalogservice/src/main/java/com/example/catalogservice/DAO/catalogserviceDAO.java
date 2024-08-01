package com.example.catalogservice.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.catalogservice.model.User;
@Repository
public class catalogserviceDAO{
	
	List<User> users;

	public catalogserviceDAO() {
		users = new ArrayList<>();
		
		User user1 = new User("101", "123", "Xi", "xi@gmail.com");
		User user2 = new User("102", "234", "Jing", "Ji@gmail.com");
		User user3 = new User("103", "345", "Zhen Luo", "zhen@yahoo.com");
		
		
		users.add(user1);   users.add(user2);    users.add(user3);
	}
	
	public Optional<User> findUser(String userId) {
		
		return users.stream().filter(user -> user.getUserId().equals(userId)).findFirst();
		
	}

	public List<User> allUsers() {
		
		return users;
	}
}