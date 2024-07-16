package com.example.first.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.Repository.IUserRepository;
import com.example.first.model.User;

@Service
public class UserServiceImpl implements IUserService{
    
    @Autowired
	IUserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public User findByUsername(String userId, String password) {
        User user = userRepository.findUser(userId, password);
        return user;
    }
}

