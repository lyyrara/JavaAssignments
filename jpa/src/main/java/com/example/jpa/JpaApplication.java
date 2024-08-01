package com.example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.entity.User;
import com.example.jpa.repository.UserRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//User user = new User();
		//User user = new User("laurene@1234", null, "Laurene Dai");
		
		User user = new User(1, "laurene@1234", "123");
		//User user = new User(null, "234", "Jingjing Bai");
		
		userRepository.save(user);
		
		
		
		//userRepository.fetchAllUsers().forEach(user -> System.out.println(user.getUsername()+", "+user.getName()));
		
		

	}

}
