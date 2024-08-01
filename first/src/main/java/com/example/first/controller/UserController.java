package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.first.jpa.entity.User;
import com.example.first.service.IUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;





@RestController
//@RequestMapping("/user/")
public class UserController {
	@Autowired
	IUserService userService;

	// public UserController() {
	// }
	
	
	// @PostMapping("login")
	// public String login( @RequestBody Login login) {
	// 	System.out.println(login.getUsername()+", "+login.getPassword());
	// 	User u = userService.login(login.getUsername(), login.getPassword());
	// 	if(u == null){
	// 		return "Login failed.";
	// 	}
	// 	return "Login Successfull";
	// }
    

    // @PostMapping("signup")
    // public String signup(@RequestBody User user) {
    //     System.out.println(user.toString());
	// 	userService.addUser(user);
	// 	return "Sign up Successfull";
    // }

	// @PostMapping("update/{name}/{email}")
	// public String update(@PathVariable String name, @PathVariable String email){
	// 	//userService.updateUser(name, email);
	// 	System.out.println(name+", "+email);
	// 	return "Update Successfully";
	// }

	// // @DeleteMapping("delete/{userid}")
	// public String deleteUser(@PathVariable Sźring userid){
	// 	System.out.println("The userId from teh request is "+userid);
		
	// 	return "User Deleted";
	// }


	@GetMapping("/delete/{userId}")
	public ModelAndView deleteUser(@PathVariable String userId) {
		System.out.println("inside delete() "+userId);

		userService.deleteUser(userId);
		List<User> users = userService.getAllUsers();
		ModelAndView modelAndView = new ModelAndView("master_page");
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@GetMapping("/update/{userId}")
	public ModelAndView updateUserPage(@PathVariable String userId) {
		System.out.println("inside update() " + userId);
		ModelAndView modelAndView = null;
		User user = userService.findUser(userId);
		
		modelAndView = new ModelAndView("update_page");
		modelAndView.addObject("user", user);
		
	
		return modelAndView;

	}

	@PostMapping("/update")
	public ModelAndView updateUser(User user)  throws InterruptedException {
		System.out.println(user.getUserId() + ", " + user.getName());
		
		userService.updateUser(user);
		List<User> users = userService.getAllUsers();
		ModelAndView modelAndView = new ModelAndView("master_page");
		modelAndView.addObject("users", users);
		modelAndView.addObject("updateMsg", "Update is Done");
		
		return modelAndView;
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		
		System.out.println("inside logout...");
		
		HttpSession session = request.getSession(false);
		System.out.println(((User)session.getAttribute("loggedInUser")).getName());
		System.out.println("session id while logout is "+session.getId());
		
		session.invalidate();
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		return modelAndView;
	}
	
	
	

}