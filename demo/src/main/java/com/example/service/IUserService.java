package com.example.service;
import com.example.pojo.User;

public interface IUserService {
    public void saveUser(User user);

	public User searchUser(String userId);

}
