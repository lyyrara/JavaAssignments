package com.example.first.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.model.Login;
import com.example.first.model.User;
import com.example.first.service.IUserService;



@RestController
public class UserController {
	@Autowired
	IUserService userService;

	public UserController() {
	}
	
	
	@PostMapping("/login")
	public String login( @RequestBody Login login) {
		System.out.println(login.getUsername()+", "+login.getPassword());
		User u = userService.findByUsername(login.getUsername(), login.getPassword());
		if(u == null){
			return "Login failed.";
		}
		return "Login Successfull";
	}
    

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        System.out.println(user.toString());
		userService.addUser(user);
		return "Sign up Successfull";
    }
	

}