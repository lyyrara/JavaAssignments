package com.example.first.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.first.jpa.entity.User;
import com.example.first.service.IUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;




@Controller//This @Controller is supposed to return HTML/JSP page but not plain text/JSON/XML Data....
public class HomeController {

	@Autowired
	IUserService userService;

	@GetMapping("/")// "/" represents the very first page of your application
	public String homePage() {
		
		System.out.println("inside homePage()");
		
		return "index";//This String "index" is supposed to be the name of the html/jsp name. Do not expect
						//"index" as a string to be returned form the server as a plain text...
	}

	@GetMapping("/signup")// "/" represents the very first page of your application
	public String signupPage() {
		
	
		
		return "signup";//This String "index" is supposed to be the name of the html/jsp name. Do not expect
						//"index" as a string to be returned form the server as a plain text...
	}

	// @PostMapping("register")
	// public String registerUser(User user) {
	// 	System.out.println(user.toString());
		
	// 	return "index";
	// }

	@PostMapping("/login")
	public ModelAndView login(String userId, String password, HttpServletRequest request) {
		ModelAndView modelAndView;
		System.out.println(userId+", "+password);
		User user = userService.login(userId, password);
		System.out.println(user);
		if(user != null){
			HttpSession session = request.getSession();
			modelAndView = new ModelAndView("welcome");
			session.setAttribute("loggedInUser", user);
		}
		else{
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("loginFailedStatus", "Login Failed, Please Try Again!!");
		}
		return modelAndView;
	}

	@PostMapping("/register")
	public ModelAndView register(User user) {
		System.out.println(user.getUserId()+", "+user.getPassword());
		userService.addUser(user);
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("registerSuccess", "Registration Successfull, Now Please Login!!");
		
		return modelAndView;
		
	}
	
	
	
}