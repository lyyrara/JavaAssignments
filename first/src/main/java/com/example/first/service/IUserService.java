package com.example.first.service;

import java.util.List;

import com.example.first.jpa.entity.User;

public interface IUserService {
    public void addUser(User user);

    public User login(String userId, String password) ;

    public List<User> getAllUsers();

   // public String deleteUser(String userId);

    //public User findUser(String userId);
	
	//public void updateUser(User user); 

}
