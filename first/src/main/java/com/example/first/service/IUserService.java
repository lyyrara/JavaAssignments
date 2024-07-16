package com.example.first.service;

import com.example.first.model.User;

public interface IUserService {
    public void addUser(User user) ;

    public User findByUsername(String userId, String password) ;

}
