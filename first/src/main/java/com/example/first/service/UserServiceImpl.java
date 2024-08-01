package com.example.first.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first.jpa.Repository.UserRepository;
import com.example.first.jpa.entity.User;

@Service
public class UserServiceImpl implements IUserService{
    
    @Autowired
	UserRepository userRepository;

    @Override
    public void addUser(User user) {
        //userRepository.addUser(user);
        userRepository.save(user);
    }

    @Override
    public User login(String userId, String password) {
       // User user = userRepository.findUser(userId, password);
        User user = userRepository.findByUserIdAndPassword(userId, password);
        System.out.println(user+"in login service");
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        //return userRepository.getAllUsers();
        return userRepository.findAll();
    }

    // @Override
    // public String deleteUser(String userId) {
    //     //return userRepository.deleteUser(userId);
    //     //userRepository.deleteById(userId);
    //     return "User Deleted";
    // }

    

    // @Override
    // public User findUser(String userId) {
    //     Optional<User> user = userRepository.findById(userId);
    //     if (user.isPresent()) {
    //         return user.get();
    //     }
    //     return null;
    // }

    // @Override
    // public void updateUser(User user) {
    //     userRepository.save(user);
    // }

   
}

