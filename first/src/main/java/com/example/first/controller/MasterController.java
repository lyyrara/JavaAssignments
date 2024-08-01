package com.example.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.first.jpa.entity.User;
import com.example.first.service.IUserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MasterController {
    @Autowired
    IUserService userService;

    @GetMapping("/master")
    public ModelAndView masterModule(HttpServletRequest request) {
        ModelAndView modelAndView;
        HttpSession session = request.getSession(false);
        if(session != null){
            if(((User) session.getAttribute("loggedInUser")).getRole().equals("Admin") ){
                List<User> users = userService.getAllUsers();
                modelAndView = new ModelAndView("master_page");
                modelAndView.addObject("users", users);
            }
            else{
                modelAndView = new ModelAndView("index");
			    modelAndView.addObject("unauthorizedMessage", "You are not authorised, please login with Admin Credentials");
		
            }
            
        }
        else{
            modelAndView = new ModelAndView("index");
			modelAndView.addObject("unauthenticatedMessage", "You are not authenticated, please login first");
		
        }
        
    
        return modelAndView;
    }
    
}
