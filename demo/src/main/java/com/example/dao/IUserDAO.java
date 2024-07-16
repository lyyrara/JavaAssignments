package com.example.dao;

import java.util.List;

import com.example.pojo.User;

public interface IUserDAO {
    public void addUser(User user);
    public User findUser(String userId);
    public  List<User> allUsers();
}
