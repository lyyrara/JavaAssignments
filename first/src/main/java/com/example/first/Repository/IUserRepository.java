package com.example.first.Repository;

import java.util.List;

import com.example.first.model.User;


public interface IUserRepository {
    public void addUser(User user);

    public User findUser(String userId, String password);

    public List<User> getAllUsers();

    public String deleteUser(String userId);

    public User findUser(String userId);

    public void updateUser(User user);

}
