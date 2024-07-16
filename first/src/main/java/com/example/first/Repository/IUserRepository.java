package com.example.first.Repository;

import com.example.first.model.User;


public interface IUserRepository {
    public void addUser(User user);

    public User findUser(String userId, String password);

}
